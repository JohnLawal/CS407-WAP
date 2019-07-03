// window.onload = function() {
// let bankForm = document.getElementsByTagName("form")[0];
// bankForm.onsubmit = function() {
//     let textArea = document.getElementsByTagName("textarea")[0];
//     textArea.value = "Hey";
// }
// };




let accountInfoList = [];

// const AccountModule = (function() {
//     const accounts_array = [];
//     const createAccount = function(account_name, deposit) {
//         accounts_array.push({ accname: account_name, depo: deposit });
//     };
//     return {
//         createAccount: function(accname, deposit) { createAccount(accname, deposit) },
//         getAccounts: function() { return accounts_array }
//     };
// })();



const AccountModule = (function() {
    const createAccount = function(account_name, deposit) {
        return {
            "Account Name": account_name,
            "Balance": deposit
        }
    };
    return {
        createAccount: function(accname, deposit) { return createAccount(accname, deposit) }
    };
})();

function createAccount() {
    var accname = document.getElementById("acc_name").value;
    var deposit = document.getElementById("deposit").value;

    var account = AccountModule.createAccount(accname, deposit);


    accountInfoList.push(account);


    populateTextArea();
}

function populateTextArea() {
    var textArea = document.getElementById("created_account");

    textArea.value = "";
    for (const account of accountInfoList) {
        for (const key in account) {
            textArea.value += `${key}: ${account[key]}; `;
        }
        textArea.value += "\n";
    }
}