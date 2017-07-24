var WatchkeepingManagement = (function (window, $, document, undefined) {
	'use strict';
	//日期输出格式
	Date.prototype.format = function(format){ 
		var o = { 
		"M+" : this.getMonth()+1, //month 
		"d+" : this.getDate(), //day 
		"h+" : this.getHours(), //hour 
		"m+" : this.getMinutes(), //minute 
		"s+" : this.getSeconds(), //second 
		"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
		"S" : this.getMilliseconds() //millisecond 
		}

		if(/(y+)/.test(format)) { 
		format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
		}

		for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
		format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		} 
		} 
		return format; 
		}
	
	//校验日期大小			
	function checkDate(str){
		var now = new Date(); 
		var nowDate=now.format("yyyy-MM-dd");
		if(nowDate>str){
			alert("不能对过去时间进行操作！");
			return false;
		}else{
			return true;
		}
	}
	//时间格式校验
	function checkTime(str){
	    var re =/^([0-2][0-9]):([0-5][0-9])$/ ;
	    if(re.test(str)){
	        return true;
	    }else{
	        alert("时间格式错误，应为：00:00");
	        return false;
	    }          
	}
	//校验日期格式
	function checkD(str){
		var re=/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
		if(re.test(str)){
	        return true;
	    }else{
	        alert("日期格式错误，应为：yyyy-mm-dd");
	        return false;
	    }  
	}
	
	
	//表单提交前校验
	var jsCheck=function(){
		    var watchDatess=$("#watchDatess").val();
		    var subfield=$("#subfield").val();
		    var host=$("#host").val();
		    var vice=$("#vice").val();
		    var host1=$("#host1").val();
		    var vice1=$("#vice1").val();
		    var host2=$("#host2").val();
		    var vice2=$("#vice2").val();
		    var startTime=$("#startTime").val();
		    var endTime=$("#endTime").val();
		    var startTime1=$("#startTime1").val();
		    var endTime1=$("#endTime1").val(); 
		    var startTime2=$("#startTime2").val();
		    var endTime2=$("#endTime2").val();
		    var jshost=$("#js_host");
		    var jsvice=$("#js_vice");
		    var jshost1=$("#js_host1");
		    var jsvice1=$("#js_vice1");
		    var jshost2=$("#js_host2");
		    var jsvice2=$("#js_vice2");
		    
		    
		   
		    if($.trim(watchDatess)==''){
		    	alert("请输入日期！");
		    	return false;
		    }else if(!checkD(watchDatess)){
		    	return false;
		    }
		    
		    if($.trim(subfield)==''){
		    	alert("请填写中心！");
		    	return false;
		    }else if(subfield.length>50){
		    	alert("中心过长！");
		    	return false;
		    }
		   
		    if($.trim(host) != ''){
		    	if(startTime=='' || endTime==''){
		    		alert("有值班人时，时间不能为空！");
		    		return false;
		    	}
		    	var jsH=$("#host").find("option:selected").text();
		    	jshost.val(jsH);
		    }
		    if($.trim(vice) != ''){
		    	if($.trim(host) == ''){
		    		alert("主值班人不能为空！");
		    		return false;
		    	}
		    	var jsV=$("#vice").find("option:selected").text();
		    	jsvice.val(jsV);
		    }
		    
		    if($.trim(host1) != ''){
		    	if(startTime1=='' || endTime1==''){
		    		alert("有值班人时，时间不能为空！");
		    		return false;
		    	}
		    	var jsH1=$("#host1").find("option:selected").text();
		    	jshost1.val(jsH1);
		    }
		    if($.trim(vice1) != ''){
		    	if($.trim(host1) == ''){
		    		alert("主值班人不能为空！");
		    		return false;
		    	}
		    	var jsV1=$("#vice1").find("option:selected").text();
		    	jsvice1.val(jsV1);
		    }
		    
		    if($.trim(host2) != ''){
		    	if(startTime2=='' || endTime2==''){
		    		alert("有值班人时，时间不能为空！");
		    		return false;
		    	}
		    	var jsH2=$("#host2").find("option:selected").text();
		    	jshost2.val(jsH2);
		    }
		    if($.trim(vice2) != ''){
		    	if($.trim(host2) == ''){
		    		alert("主值班人不能为空！");
		    		return false;
		    	}
		    	var jsV2=$("#vice2").find("option:selected").text();
		    	jsvice2.val(jsV2);
		    }
		    
		    if($.trim(startTime) != '' || $.trim(endTime) != ''){
		    	if($.trim(host) == ''){
		    		alert("主值班人不能为空！");
		    		return false;
		    	}
		    }
		    if($.trim(startTime1) != '' || $.trim(endTime1) != ''){
		    	if($.trim(host1) == ''){
		    		alert("主值班人不能为空！");
		    		return false;
		    	}
		    }
		    if(startTime2!= '' || endTime2!= ''){
		    	if($.trim(host2) == ''){
		    		alert("主值班人不能为空！");
		    		return false;
		    	}
		    }
		    
		    if(startTime!=''&& endTime!=''){
		    	if(!checkTime(startTime)){
		    		return false;
		    	}
		    	if(!checkTime(endTime)){
		    		return false;
		    	}
		    	if($.trim(host) == ''){
			    	alert("主值班人不能为空！");
			    	return false;
			    }
		    	if(startTime>=endTime){
		    		alert("开始时间不能大于结束时间！");
		    		return false;
		    	}
		    	
		    }
		    
		    if(startTime1!=''&& endTime1!=''){
		    	if(!checkTime(startTime1)){
		    		return false;
		    	}
		    	if(!checkTime(endTime1)){
		    		return false;
		    	}
		    	if($.trim(host1) == ''){
			    	alert("主值班人不能为空！");
			    	return false;
			    }
		    	if(startTime1>=endTime1){
		    		alert("开始时间不能大于结束时间！");
		    		return false;
		    	}
		    }
		    
		    if(startTime2!=''&& endTime2!=''){
		    	if(!checkTime(startTime2)){
		    		return false;
		    	}
		    	if(!checkTime(endTime2)){
		    		return false;
		    	}
		    	if($.trim(host2) == ''){
			    	alert("主值班人不能为空！");
			    	return false;
			    }
		    	if(startTime2>=endTime2){
		    		alert("开始时间不能大于结束时间！");
		    		return false;
		    	}
		    }
		    
		    if(endTime!=''&& startTime1!=''){
		    	if(startTime1<endTime){
		    		alert("新开始时间不能小于上一班结束时！");
		    		return false;
		    	}
		    }
		    
		    if(endTime1!=''&& startTime2!=''){
		    	if(startTime2<endTime1){
		    		alert("新开始时间不能小于上一班结束时！");
		    		return false;
		    	}
		    }
		    
		    return true;
	}
	
	//保存
   $('#addWatch').click(function(){
		if(jsCheck()){
		   $.ajax({            
	           type: "POST",
	           url:"addScheduleInfo!addScheduleInfo.action",
	           data: $("#editWatchForm").serialize(),// formid
	           async: true,
	           dataType:"json",
	           error: function() {
	                 alert("操作失败！");     
	            },
	           success: function(data) {
	           	  if(data==1){
	           		  alert("操作成功！");
	           		  window.location.href='getDate!getDate.action?watchT='+$("#watchDatess").val(); 
	           	  }else if(data==9){
	           		 alert("不能对过去值班信息进行操作"); 
	           	  }else if(data==10){
	           		 alert("这个日期已安排人员值班，故不能再安排值班！");  
	           	  }else{
	           		 alert("操作失败！");
	           	  }
	              
	         	}
	      });
		 }
	});
   //左右交互
   function alternating(time){
	  var da=time;
	   if(time!=0){
		   $.ajax({            
	           type: "POST",
	           url:"getScheduleInfoNew!getScheduleInfoNew.action",
	           data: "watchtime="+time,
	           async: true,
	           dataType:"json",
	           error: function() {
	                 alert("网络出现问题，请联系管理员！");     
	            },
	           success: function(data) {
	        	  
	        	  if(data.length>0) {
	        		   var s=data[0].site;
	        		   if(s==1){
	        			  $("#editWatch").addClass('hide');
	        		   } else {
	        			   $("#editWatch").removeClass('hide');
	        		   }
	        		   $("#watchDatess").val(da);
	        		   $("#subfield").val(data[0].subfield);
		    		   $("#id").val(data[0].id);
		    		   $("#watchDate").val(data[0].watchDate);
		    		   
		    		   $("#host").val(data[0].directWatchNo);
		    		   $("#vice").val(data[0].auxiliaryWatchNo);
		    		   $("#startTime").val(data[0].startTime);
		    		   $("#endTime").val(data[0].endTime);
	        	  }else{
	        		  $(".edit-today-watch select").val(''); 
	        		  $(".edit-today-watch input[type=text]").val(''); 
	        		  $("#watchDatess").val(da);
	        	  }
	        	  if(data.length>1) {
	        		  $("#id1").val(data[1].id);
		    		   $("#host1").val(data[1].directWatchNo);
		    		   $("#vice1").val(data[1].auxiliaryWatchNo);
		    		   $("#startTime1").val(data[1].startTime);
		    		   $("#endTime1").val(data[1].endTime); 
	        	  }else{
	        		  $("#id1").val('');
		    		   $("#host1").val('');
		    		   $("#vice1").val('');
		    		   $("#startTime1").val('');
		    		   $("#endTime1").val(''); 
		    		   $("#id2").val('');
		    		   $("#host2").val('');
		    		   $("#vice2").val('');
		    		   $("#startTime2").val('');
		    		   $("#endTime2").val(''); 
	        	  }
	        	  
	        	  if(data.length>2){
	        		   $("#id2").val(data[2].id);
		    		   $("#host2").val(data[2].directWatchNo);
		    		   $("#vice2").val(data[2].auxiliaryWatchNo);
		    		   $("#startTime2").val(data[2].startTime);
		    		   $("#endTime2").val(data[2].endTime);  
	        	  }else{
	        		  $("#id2").val('');
		    		   $("#host2").val('');
		    		   $("#vice2").val('');
		    		   $("#startTime2").val('');
		    		   $("#endTime2").val(''); 
	        	  }
	        	    
	           }
		   });
	   }else{
		   alert("请选择本月日期，谢谢配合！");
	   }
	   
   }
	return {
		//点击日历js方法
		calendarWidget: function (){
			var $calendar   = $('#js-Watchkeeping-calendar');
            var $table      = $calendar.find('.custom-calendar-table');
            var $prevMonth  = $calendar.find('.fa-chevron-left');
            var $nextMonth  = $calendar.find('.fa-chevron-right');
            var $year       = $('#js_year');
            var $currentMonth = $calendar.find('.calendar-select-time').children('span');

        					   var currentYear = $year.val();//当期选中年份
        		        	   var crrentVal = parseInt($currentMonth.text());//当前显示月份
        		        	   var months;
        		        	   var years;
        		        	   //上个月
        		        	   $prevMonth.on('click', function (){
        		        		   if( crrentVal == 1 ) {
        		        			   months=12;
        		        			   years=currentYear-1;
        		        			   currentYear=currentYear-1;
        		        			   $year.html("<option value='" + currentYear
           							+ "'>" + currentYear+ "</option>");
        		        		   } else {
        		        			   months=crrentVal-1;
        		        			   years=currentYear;
        		        		   }
        		        		  
        		        		   $("#updateWatchDate").attr('action',"getDate!getDate.action");
        			   				$("#lid").val(months);
        			   				$("#lids").val(years);
        			   				$("#lid").attr('name','months');
        			   				$("#lids").attr('name','years');
        			   				$("#updateWatchDate").submit();
        		        	   });
        		        	   //下个月
        		        	   $nextMonth.on('click', function (){
        		        		   if( crrentVal == 12 ) {
        		        			   months=1;
        		        			   years=Number(currentYear)+1;
        		        			   currentYear=years;
        		        			   $year.html("<option value='" + currentYear
        	           							+ "'>" + currentYear+ "</option>");
        		        		   } else {
        		        			   months=crrentVal+1;
        		        			   years=currentYear;
        		        		   }
        		        		   $("#updateWatchDate").attr('action',"getDate!getDate.action");
        			   				$("#lid").val(months);
        			   				$("#lids").val(years);
        			   				$("#lid").attr('name','months');
        			   				$("#lids").attr('name','years');
        			   				$("#updateWatchDate").submit();
        		        	   });
                             //选中年
        		        	   $year.on('change', function(event){
        		        		 var self = this;
        		        		 years=self.options[self.selectedIndex].text ;
        		        		 months=crrentVal;
        		        		$("#updateWatchDate").attr('action',"getDate!getDate.action");
     			   				$("#lid").val(months);
     			   				$("#lids").val(years);
     			   				$("#lid").attr('name','months');
     			   				$("#lids").attr('name','years');
     			   				$("#updateWatchDate").submit();
        		        	 }); 
        				
              
        	  
//           monthChange(); 
            
            $table.on('click', 'tbody td span', function(){
                var $td = $(this).parent(); 
                var watchTime= $td.find('input').val();
                alternating(watchTime);//根据日期后期值班信息显示到左侧页面
                
                $table.find('.custom-calendar-day').removeClass('custom-calendar-select-day');
                $td.addClass('custom-calendar-select-day');
            });
		}
	};	
})(window, jQuery, document);