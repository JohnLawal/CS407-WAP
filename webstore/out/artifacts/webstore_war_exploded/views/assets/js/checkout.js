// let $ = jQuery;

function checkout() {
    let address = $('#txtAddress').val();
    let location = $('#optCity').val();
    let payment_method = $('#optPayment').val();
//
    let proceedUrl = "/webstore/checkout";
    let fd = {
        "address": address,
        "location": location,
        "payment_method": payment_method
    };

    //
    $('body').preloader();
    $.ajax({
        type: 'POST',
        url: proceedUrl,
        data: fd,
        success: function (result) {
            $('body').preloader('remove');
            let resultObj = JSON.parse(result);
            if (resultObj['status'] === "success") {
                refreshCart();
                let purchaseAmount = parseFloat(resultObj['amount']);
                let deliveryfee = parseFloat(resultObj['delivery_fee']);
                let purchase = resultObj['purchases'];
                displayPurchaseDetails(purchase, purchaseAmount, deliveryfee);
            } else {
                $.alert({
                    title: 'Could not proceed',
                    content: 'Could not complete the process. ' + resultObj['message']
                });
            }


        },
        error: function (xhr, status, error) {
            $('body').preloader('remove');

            $.alert({
                title: 'Could not proceed',
                content: 'Could not complete the process. ' + error
            });

        }
    });
}

function displayPurchaseDetails(purchase, purchaseAmount, deliveryfee) {
    //for pay on delivery
    $('#frmCheckout').remove();
    //we know it is Delivery
    //let user know that he needs to prepare purchaseAmount + deliveryfee while we send our experts
    let text_p = '<h4>Success</h4>' +
        '<p>Your order has been received and your invoice has been sent to your email address.</p>' +
        '<p>Our experts will be with you shortly to configure your purchases for you at your location.</p>' +
        '<p>The delivery fee for your order is <b>$' + numberWithCommas(deliveryfee) + '</b></p>' +
        '<p>Your total fee is <b>$' + numberWithCommas(purchaseAmount + deliveryfee) + '</b>. Please ensure to have it with you for payment.</p>';
    $('#leftSide').html(text_p);
    $('html,body').animate({scrollTop: $("#categories").offset().top}, 'slow');


    //the red bar by the side
    $('#containerTitle').text('Your Order');
    $('#continuebtn').remove();
    let purchasetotal = 0;
    let itemspurchased = "<ul>";
    for (let i = 0; i < purchase.length; i++) {
        let product_name = purchase[i].product_name;
        let product_price = parseFloat(purchase[i].selling_price);
        let product_qty = purchase[i].quantity;
        let product_sub_price = product_price * product_qty;//the total price for the quantity added
        purchasetotal += product_sub_price;
        itemspurchased += '<li>' +
            '<span class="chk-itm">' + $.trim(product_name) + '</span>' +
            '<span class="chk-qty">:' + numberWithCommas(product_qty) + '</span> = ' +
            '<span class="chk-price">$' + numberWithCommas(product_sub_price) + '</span>' +
            '</li>';
    }
    itemspurchased += "</ul>";
    $('#purchaselist').html(itemspurchased);
    $('#cartamounts').remove();
    let summary = '<li><b>Sub-total : </b>$<span class="">' + numberWithCommas(purchasetotal) + '</span></li>';
    summary += '<li><b>Delivery Fee : </b>$<span class="">' + numberWithCommas(deliveryfee) + '</span></li>';
    summary += '<li><b>Total : </b>$<span class="">' + numberWithCommas(deliveryfee + purchasetotal) + '</span></li>';
    $('#purchaseamounts').html(summary);
}
