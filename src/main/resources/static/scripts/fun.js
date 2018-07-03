function sureBuy(id,pr) {
    var money = document.getElementById('getRMBvalue').value;

    // var pr = [[${carServiceDO.price}]];

    if(parseFloat(money)< parseFloat(pr)){
        alert("金额不足！");
        return;
    }

    var dlform = document.createElement('form');
    dlform.style = "display:none;";
    dlform.method = 'post';
    dlform.action = '../saleRecord/buy';
    var hdnFilePath = document.createElement('input');
    hdnFilePath.type = 'hidden';
    hdnFilePath.name = 'id';
    hdnFilePath.value = id;
    dlform.appendChild(hdnFilePath);
    var moneyInput = document.createElement('input');
    moneyInput.type = 'hidden';
    moneyInput.name = 'money';
    moneyInput.value = money;
    dlform.appendChild(moneyInput);
    document.body.appendChild(dlform);
    dlform.submit();
    document.body.removeChild(dlform);

}


function go_back() {

    var money=document.getElementById("getRMBvalue").value;
    if (0 != money){
        alert("请取走现金！");
    }
    window.location.replace("../../")
}