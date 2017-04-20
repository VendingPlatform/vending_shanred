/**
 * 
 */
function clearWareInput() {
	$("#wareCode").val(null);
	$("#wareCode").attr("readonly", false);
	$("#wareName").val(null);
	$("#wareNorm").val(null);
	$("#wareUnit").val(null);
	$("#wareBasePrice").val(null);
	$("#wareDesc").val(null);
	$("#subBtn").attr("onclick", "insertWareInfo()");
	$("#waretitle").html("添加商品");
}
function insertWareInfo() {
	$.ajax({
		url : "../ware/insertWareInfo",
		type : "post",
		dataType : "text",
		data : $("#insertWareForm").serialize(),
		success : function(response) {
			alert(response);
			location.reload();
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}

function getWareToUpdate(wareId) {
	$.ajax({
		url : "../ware/getWareInoById?wareId=" + wareId,
		type : "get",
		dataType : "json",
		success : function(data) {
			$("#wareCode").val(data.wareCode);
			$("#wareCode").attr("readonly", true);
			$("#wareName").val(data.wareName);
			$("#wareNorm").val(data.wareNorm);
			$("#wareUnit").val(data.wareUnit);
			$("#wareBasePrice").val(data.wareBasePrice);
			$("#wareDesc").val(data.wareDesc);
			$("#subBtn").attr("onclick", "updateWareInfo(" + wareId + ")");
			$("#waretitle").html("更新商品");
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}

function updateWareInfo(wareId) {
	$.ajax({
		url : "../ware/updateWareInfo?wareId=" + wareId,
		type : "post",
		dataType : "text",
		data : $("#insertWareForm").serialize(),
		success : function(response) {
			alert("更新成功");
			location.reload();
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}

function getWareToAssign(firmId) {
	$.ajax({
		url : "../../ware/getAllWareInfosByFirm/"+firmId,
		type : "get",
		dataType : "json",
		success : function(res) {
			$("#wareIdInput").empty();
			$("#wareIdInput").append("<option >---选择商品---</option>");
			for(i in res){
				var html = "<option value="+res[i].wareId+">"+res[i].wareName+"</option>";
				$("#wareIdInput").append(html);
			}
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}