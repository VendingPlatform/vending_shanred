function intoSaaSRent(basePath) {
	$.ajax({
		url : "saas/rentSaas",
		type : "get",
		dataType : "text",
		success : function(res) {
			alert(res);
			location.reload();
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}

function validateSaas(firmName, code, basePath) {
	$.ajax({
		url : basePath + "saas/validateSaasRent/" + firmName + "/" + code,
		type : "get",
		dataType : "text",
		success : function(res) {
			if (res == "repeatName") {
				alert("名称被占用，请重置");
				document.getElementById("firmName").value = "";
				document.getElementById("firmName").focus();
			}
			if (res == "repeatCode") {
				alert("编号被占用，请重置");
				document.getElementById("firmCode").value = "";
				document.getElementById("firmCode").focus();
			}
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}
function getValue(val, basePath) {
	document.getElementById("rentTime").value = val;
	calculateMoney(basePath);
}
function calculateMoney(basePath) {
	var firmType = document.getElementById("firmType").value;
	var rentTime = document.getElementById("rentTime").value;
	var machineNum = document.getElementById("machineNum").value;
	if (firmType != "" && rentTime != "" && machineNum != "") {
		$.ajax({
			url : basePath + "saas/calculateMoney",
			data : {
				"firmType" : firmType,
				"rentTime" : rentTime,
				"machineNum" : machineNum
			},
			dataType : "text",
			type : "post",
			success : function(res) {
				// alert("计算价格为" + res);
				document.getElementById("sumPrice").value = res;
			},
			error : function() {
				alert("获取信息失败");
			}
		});
	}
}

function submitRent(basePath) {
	var firmType = document.getElementById("firmType").value;
	var firmName = document.getElementById("firmName").value;
	var firmNo = document.getElementById("firmCode").value;
	var password = document.getElementById("password").value;
	var machineNum = document.getElementById("machineNum").value;
	var rentTime = document.getElementById("rentTime").value;
	var sumPrice = document.getElementById("sumPrice").value;
	if (firmType != "" && firmName != "" && firmNo != "" && password != ""
			&& rentTime != "" && machineNum != "" && sumPrice != "") {
		
		$.ajax({
			url : basePath + "saas/createNewSaasRent",
			data : {
				"firmType" : firmType,
				"firmName" : firmName,
				"firmNo" : firmNo,
				"password" : password,
				"sumPrice" : sumPrice,
				"rentTime" : rentTime,
				"machineNum" : machineNum
			},
			dataType : "text",
			type : "post",
			success : function(res) {
				//alert(res);
				window.location.href=basePath+"viewpage/login.jsp";
			},
			error : function() {
				alert("租用失败");
			}
		});
	}
}
