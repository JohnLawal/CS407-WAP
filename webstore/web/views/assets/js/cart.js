// $(function () {
//     refreshCart();
// });
//
//
// function addToCart(productid) {
//     var quantity = $('#txtQuantity').val();
//     var addUrl = "/foodland/addToCart";
//     var fd = new FormData();
//     fd.append("product_id", productid);
//     fd.append("quantity", quantity);
//
//     //
//     $('body').preloader();
//     $.ajax({
//         contentType: false,
//         processData: false,
//         type: 'POST',
//         url: addUrl,
//         data: fd,
//         success: function (result) {
//             var resultObj = JSON.parse(result);
//             if (resultObj['status'] === "success") {
//                 //notify user of addition
//
//                 $('#txtQuantity').val(1);
//                 refreshCart();
//                 $('body').preloader('remove');
//                 $.notify({
//                     message: "Your cart has been updated."
//                 }, {
//                     type: 'warning',
//                     timer: 1000,
//                     placement: {
//                         from: 'top',
//                         align: 'center'
//                     }
//                 });
//             } else {
//                 $('body').preloader('remove');
//                 $.alert({
//                     title: 'Not Added',
//                     content: 'Could not complete the process. ' + resultObj['message']
//                 });
//             }
//
//
//         },
//         error: function (xhr, status, error) {
//             $.alert({
//                 title: 'Not Added',
//                 content: 'Could not complete the process. ' + error
//             });
//
//         }
//     });
// }
//
// function removeFromCart(productid) {
//     $.confirm({
//         title: 'Are you sure you want to remove this item from your cart?',
//         content: "",
//         buttons: {
//             cancel: {
//                 text: 'Cancel',
//                 btnClass: 'btn btn-default'
//             },
//             confirm: {
//                 text: "Remove",
//                 btnClass: 'btn btn-success',
//                 action: function () {
//                     var removeUrl = "/foodland/removeFromCart";
//                     var fd = new FormData();
//                     fd.append("product_id", productid);
//
//                     //
//                     $('body').preloader();
//                     $.ajax({
//                         contentType: false,
//                         processData: false,
//                         type: 'POST',
//                         url: removeUrl,
//                         data: fd,
//                         success: function (result) {
//                             var resultObj = JSON.parse(result);
//                             if (resultObj['status'] === "success") {
//                                 refreshCart();
//                                 $('body').preloader('remove');
//                                 $.notify({
//                                     message: "Your cart has been updated."
//                                 }, {
//                                     type: 'success',
//                                     timer: 1000,
//                                     placement: {
//                                         from: 'top',
//                                         align: 'center'
//                                     }
//                                 });
//                             } else {
//                                 $('body').preloader('remove');
//                                 $.alert({
//                                     title: 'Not Removed',
//                                     content: 'Could not complete the process. ' + resultObj['message']
//                                 });
//                             }
//
//
//                         },
//                         error: function (xhr, status, error) {
//                             $.alert({
//                                 title: 'Not Removed',
//                                 content: 'Could not complete the process. ' + error
//                             });
//
//                         }
//                     });
//                 }
//             }
//         }
//     });
// }
//
// function editqty(productid, product_name, product_quantity) {
//     $.confirm({
//         title: 'Update Quantity Of ' + product_name,
//         content: '' +
//                 '<form action="" class="formName" role="form">' +
//                 '<div class="form-group">' +
//                 '<label>Enter Quantity</label>' +
//                 '<input type="number" id="eQuantity" value ="' + product_quantity + '" class="name form-control" required="">' +
//                 '</div>' +
//                 '</form>',
//         buttons: {
//             cancel: function () {
//                 //close
//             },
//             formSubmit: {
//                 text: 'Update',
//                 btnClass: 'btn-warning',
//                 action: function () {
//                     quantity = this.$content.find('#eQuantity').val();
//
//                     if (!quantity) {
//                         $.alert('Please provide the quantity.');
//                         return false;
//                     }
//
//                     $.confirm({
//                         title: 'Please confirm the update',
//                         type: 'orange',
//                         content: 'Click Update to continue',
//                         buttons: {
//                             cancel: function () {
//                             },
//                             proceed: {
//                                 text: 'Update',
//                                 btnClass: 'btn btn-warning',
//                                 action: function () {
//                                     var updateUrl = "/foodland/updateItemInCart";
//                                     var fd = new FormData();
//                                     fd.append("product_id", productid);
//                                     fd.append("quantity", quantity);
//
//                                     //
//                                     $('body').preloader();
//                                     $.ajax({
//                                         contentType: false,
//                                         processData: false,
//                                         type: 'POST',
//                                         url: updateUrl,
//                                         data: fd,
//                                         success: function (result) {
//                                             var resultObj = JSON.parse(result);
//                                             if (resultObj['status'] === "success") {
//                                                 refreshCart();
//                                                 $('body').preloader('remove');
//                                                 $.notify({
//                                                     message: "Your cart has been updated."
//                                                 }, {
//                                                     type: 'warning',
//                                                     timer: 1000,
//                                                     placement: {
//                                                         from: 'top',
//                                                         align: 'center'
//                                                     }
//                                                 });
//                                             } else {
//                                                 $('body').preloader('remove');
//                                                 $.alert({
//                                                     title: 'Not Updated',
//                                                     content: 'Could not complete the process. ' + resultObj['message']
//                                                 });
//                                             }
//
//
//                                         },
//                                         error: function (xhr, status, error) {
//                                             $.alert({
//                                                 title: 'Not Updated',
//                                                 content: 'Could not complete the process. ' + error
//                                             });
//
//                                         }
//                                     });
//                                 }
//                             }
//                         }
//                     });
//                 }
//             }
//         },
//         onContentReady: function () {
//             // bind to events
//             var jc = this;
//             this.$content.find('form').on('submit', function (e) {
//                 // if the user submits the form by pressing enter in the field.
//                 e.preventDefault();
//                 jc.$$formSubmit.trigger('click'); // reference the button and click it
//             });
//         }
//     });
// }
//
// function clearCart() {
//     $.confirm({
//         title: 'Are you sure you want to remove all items from your cart?',
//         content: "",
//         buttons: {
//             cancel: {
//                 text: 'Cancel',
//                 btnClass: 'btn btn-default'
//             },
//             confirm: {
//                 text: "Remove",
//                 btnClass: 'btn btn-success',
//                 action: function () {
//                     var removeUrl = "/foodland/clearCart";
//                     //
//                     $('body').preloader();
//                     $.ajax({
//                         type: 'POST',
//                         url: removeUrl,
//                         data: {},
//                         success: function (result) {
//                             var resultObj = JSON.parse(result);
//                             if (resultObj['status'] === "success") {
//                                 refreshCart();
//                                 $('body').preloader('remove');
//                                 $.notify({
//                                     message: "Your cart has been cleared."
//                                 }, {
//                                     type: 'success',
//                                     timer: 1000,
//                                     placement: {
//                                         from: 'top',
//                                         align: 'center'
//                                     }
//                                 });
//                             } else {
//                                 $('body').preloader('remove');
//                                 $.alert({
//                                     title: 'Not Cleared',
//                                     content: 'Could not complete the process. ' + resultObj['message']
//                                 });
//                             }
//
//
//                         },
//                         error: function (xhr, status, error) {
//                             $.alert({
//                                 title: 'Not Cleared',
//                                 content: 'Could not complete the process. ' + error
//                             });
//
//                         }
//                     });
//                 }
//             }
//         }
//     });
// }
//
// function refreshCart() {
//
//     $.ajax({
//         contentType: false,
//         processData: false,
//         type: 'POST',
//         url: '/foodland/getCart',
//         data: {},
//         success: function (result) {
//             var resultObj = JSON.parse(result);
//             if (resultObj['status'] === "success") {
//                 $('.checkout-items').html('');
//                 var cart = resultObj['cart'];
//                 var cartnum = cart.length;
//                 var subtotal = 0;
//
//                 //refreshes the container for cart and the modal for cart
//                 //also computes the subtotal
//                 for (var i = 0; i < cart.length; i++) {
//                     product_id = cart[i].product_id;
//                     product_name = cart[i].product_name;
//                     product_price = parseFloat(cart[i].selling_price);
//                     product_qty = cart[i].quantity;
//                     product_sub_price = product_price * product_qty;//the total price for the quantity added
//
//                     subtotal += product_sub_price;
//                     $('.checkout-items').append('<li>' +
//                             '<span class="chk-itm">' + $.trim(product_name) + '</span>' +
//                             '<span class="chk-qty">:' + numberWithCommas(product_qty) + '</span> = ' +
//                             '<span class="chk-price">&#8358;' + numberWithCommas(product_sub_price) + '</span>' +
//                             '<a style="color: #f3e30a; padding:3px;" onclick="editqty(\'' + product_id + '\',\'' + product_name + '\',\'' + product_qty + '\');" href="javascript:void(0)" ><i class="fa fa-edit"></i></a>' +
//                             '<a style="color: #f3e30a" onclick="removeFromCart(\'' + product_id + '\');" href="javascript:void(0)" ><i class="fa fa-trash"></i></a>' +
//                             '</li>');
//                 }
//                 $('.sub-total').text(numberWithCommas(subtotal));
//                 //refresh the count on the header
//                 $('#cartno').text(numberWithCommas(cartnum));
//                 $('#cartno').data('no', cartnum);
//
//                 if (cartnum > 0) {
//                     $('.cart_checkout').attr('disabled', false);//enable checkout button
//                 } else {
//                     $('.cart_checkout').attr('disabled', true);//disable checkout button
//                 }
//             }
//
//
//         },
//         error: function (xhr, status, error) {
//             $.alert({
//                 title: 'Not Added',
//                 content: 'Could not complete the process. ' + error
//             });
//
//         }
//     });
// }

// const numberWithCommas = function (x) {
//     return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
// }
//
