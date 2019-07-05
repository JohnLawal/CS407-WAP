"use strict";

window.onload = function() {
    let accountInfoList = [];

    const AccountModule = (function() {
        const createAccount = function(account_name, deposit) {
            return {
                "Account Name": account_name,
                "Balance": deposit * 1
            };
        };
        return {
            createAccount: function(accname, deposit) { return createAccount(accname, deposit); }
        };
    })();

    document.getElementById("btnSubmit").onclick = function() {
        var accname = document.getElementById("acc_name").value.trim(); //value from account name text box
        var deposit = document.getElementById("deposit").value.trim(); //value from deposit text box

        if (accname && deposit) {
            var account = AccountModule.createAccount(accname, deposit); // a new account object

            let flag = false;
            for (const savedAccount of accountInfoList) {
                if (savedAccount["Account Name"] === account["Account Name"]) {
                    var currIndex = accountInfoList.indexOf(savedAccount);

                    savedAccount.Balance += account.Balance;
                    accountInfoList[currIndex] = savedAccount; //update the balance of the account
                    flag = true;
                }
            }

            if (!flag) {
                accountInfoList.push(account); // add a new account object to the list of accounts
            }

            populateTextArea(); // update the text area for created accounts
        } else {
            alert("Please provide the account name and deposit amount");
        }
    };

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
};