
$(function() {
	$('#js-save-btn').on('click', function() {
		if(check()){
		  newTaskFn();
		}
	});
});
/**
 * 新建任务 提交表单
 * 
 * @returns
 */
var newTaskFn = function() {
	$('#js-new-task-form').ajaxSubmit({
		target : "#output",
		beforSubmit : function() {
			// 表单提交前调用的function
		},
		success : function(responseText, statusText) {
			alert(responseText.msg);
			if (responseText.result) {
				// 成功后调用查询方法
				location.href = "selectTask!selectTask.action";
			} 

		},
		error : function() {
		},
		url : 'newTask!newTask.action',
		type : 'post',
		dataType : 'json',
		clearForm : false,
		resetForm : false,
		timeout : 5000
	});
};

function check() {
     var settlement = $("#systemName2").val();
     console.info(settlement); 
    if (null == settlement || "" == settlement) {
        alert("请填写客户系统!");
        return false;
    } 
    var problemType = $("#js-add-problemType").val();
    if (null == problemType || "" == problemType) {
        alert("请填写问题类型!");
        return false;
    }
    var priority = $("#js-add-priority").val();
    if (null == priority || "" == priority) {
        alert("请填写优先级别!");
        return false;
    }
    return true;

}

