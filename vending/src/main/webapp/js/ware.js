/**
 * 
 */

function addShipToUser(basePath){
	$.ajax({
		url: basePath +"ware/addShipToUser",
		data: $("#shipForm").serialize(),
		dataType:"text",
		type:"post",
		success:function(res){
			alert("出货成功");
			location.reload();
		},error :function(){
			alert("出货失败");
		}
	});
}

function removeWare(wareId){
	var tr = document.getElementById(wareId);
	tr.parentNode.removeChild(tr);
}

function selectWare(basePath) {
	$.ajax({
		url : basePath + "ware/selectWare/" + $("#wareId").val(),
		dataType : "json",
		type : "get",
		success : function(res) {
			if(res==null){
				alert("请输入商品！");
				return ;
			}
			if($("#num").val()==""||$("#num").val()==null){
				alert("请输入数量");
				return;
			}
			
			$("#userIdHidden").val($("#userId option:selected").val());
			$("#shipNoHidden").val($("#shipNo").val());
			
			var now = new Date().getTime();
			var html = "<tr id='"+now+"'>"
					  +"<td><input type='hidden' name='wareId' value="+res.wareId+"><div class='form-group'><input class='form-control'name='code' value="+ res.wareCode +" readonly/></div></td> "
				      +"<td><div class='form-group'><input type='text' class='form-control' readonly name='wareName' value="+res.wareName +"></div></td>" 
				      +"<td><div class='form-group'><input type='text' class='form-control' readonly name='num' value="+$("#num").val()  +"></div></td>"	
					  +"<td><div class='form-group'><input type='text' class='form-control' readonly name='wareBasePrice' value="+res.wareBasePrice +"></div></td>"
					  +"<td><div class='form-group'><input type='text' class='form-control' readonly name='descr' value="+$("#descr").val()+"></div></td>" 
					  +"<td><a class='btn btn-xsl' onclick='removeWare("+now+")'>删除</a></td>"
					  +"</tr>";

			$("#formTable").append(html);
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}
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
		url : "../../ware/getAllWareInfosByFirm/" + firmId,
		type : "get",
		dataType : "json",
		success : function(res) {
			$("#wareIdInput").empty();
			$("#wareIdInput").append("<option >---选择商品---</option>");
			for (i in res) {
				var html = "<option value=" + res[i].wareId + ">"
						+ res[i].wareName + "</option>";
				$("#wareIdInput").append(html);
			}
		},
		error : function() {
			alert("获取数据失败");
		}
	});
}