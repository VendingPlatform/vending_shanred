var Index = (function(window, $, document, undefined) {
	'use strict';
	var chartLists = (function() {
		var $chartOne = $('#js-chart-one'), $chartTwo = $('#js-chart-two'), $chartThree = $('#js-chart-three');

		return {
			oneChart : function(data) {
				$.plot($chartOne, [ data ], {
					series : {
						bars : {
							show : true,
							barWidth : 0.6,
							align : "center"
						}
					},
					xaxis : {
						mode : "categories",
						tickLength : 0
					},
					yaxis : {
						min:0,
						tickSize: 20
					},
					colors : [ '#1ABC9C' ],
					grid : {
						show : true,
						tickColor : "#ECF0F1",
						color : '#95A5A6',
						borderWidth : 1,
						borderColor : '#ECF0F1'

					},
					legend : {
						show : true,
						labelBoxBorderColor : 'transparent'
					}
				});
			},
			twoChart : function(data) {
				$.plot($chartTwo, [ data ], {
					series : {
						bars : {
							show : true,
							barWidth : 0.6,
							align : "center"
						}
					},
					xaxis : {
						mode : "categories",
						tickLength : 0
					},
					yaxis : {
						min:0,
						tickSize: 20
					},
					colors : [ '#E74C3C' ],
					grid : {
						show : true,
						tickColor : "#ECF0F1",
						color : '#95A5A6',
						borderWidth : 1,
						borderColor : '#ECF0F1'

					},
					legend : {
						show : true,
						labelBoxBorderColor : 'transparent'
					}
				});
			},
			threeChart : function(data) {
				$.plot($chartThree, [ data ], {
					series : {
						bars : {
							show : true,
							barWidth : 0.6,
							align : "center"
						}
					},
					xaxis : {
						mode : "categories",
						tickLength : 0
					},
					yaxis : {
						min:0,
						tickSize: 20
					},
					colors : [ '#3498DB' ],
					grid : {
						show : true,
						tickColor : "#ECF0F1",
						color : '#95A5A6',
						borderWidth : 1,
						borderColor : '#ECF0F1'

					},
					legend : {
						show : true,
						labelBoxBorderColor : 'transparent'
					}
				});
			},
			fillTableData : function(data){
				var html='';
				$(data).each(function(i) {
					html+='<tr><td>';
					html+=data[i][0];
					html+='</td><td><span class="badge bg-info">';
					html+=data[i][1];
					html+='</span></td></tr>';
				});
				return html;
			}
		};
	})();
	var chartLine = function(data) {

		var newAndRollback = [], processedAndClosed = [], processing = [], $charLine = $('#js-chart-line');
		$(data).each(function(i){
			newAndRollback.push([ data[i].month, data[i].newTask+ data[i].roll_back ]);
			processedAndClosed.push([ data[i].month, data[i].processed + data[i].closed ]);
			processing.push([ data[i].month, data[i].processing+data[i].runRollback+data[i].pending ]);
		});
		var minM=undefined==data[0]?1:data[0].month;
		var plot = $.plot($charLine, [ {
			data : newAndRollback,
			label : "新建、运维打回",
			color : '#1ABC9C'
		}, {
			data : processedAndClosed,
			label : "已处理、关闭",
			color : '#E74C3C'
		}, {
			data : processing,
			label : "待处理、处理中、运营打回",
			color : '#3498DB'
		} ], {
			series : {
				lines : {
					show : true,
					lineWidth : 3
				},
				points : {
					show : true,
					lineWidth : 3
				}
			},
			points : {
				radius : 6,
				fill : true,
				fillColor : '#fff'
			},
			grid : {
				hoverable : true,
				clickable : true,
				tickColor : "#f5f5f5",
				color : '#555',
				borderWidth : 1,
				borderColor : '#f5f5f5',
				// 刻度与网格间距
				labelMargin : 10,
				axisMargin : 1,
				margin : {
					top : 0,
					right : 20,
					bottom : 0,
					left : 0
				}
			},
			yaxis : {
				min :1 ,
				tickSize:20
			},
			xaxis : {
				min :1,
				max:12,
				tickSize:1,
				tickFormatter : function(data) {
					return data + "月";
				}
			},
			legend : {
				show : true,
				labelBoxBorderColor : 'transparent'
			}

		});

		$("<div id='tooltip'></div>").css({
			position : "absolute",
			display : "none",
			padding : "4px 8px",
			"background-color" : "#2C3E50",
			'border-radius' : '4px',
			'color' : '#fff',
			opacity : 0.9
		}).appendTo("body");

		$charLine
				.on(
						"plothover",
						function(event, pos, item) {

							if (item) {
								var x = item.datapoint[0].toFixed(0) + '月', y = item.datapoint[1]
										.toFixed(0);

								$("#tooltip").html(
										x + item.series.label + ': ' + y).css({
									top : item.pageY + 5,
									left : item.pageX + 5
								}).fadeIn(200);
							} else {
								$("#tooltip").hide();
							}
						});

	};
	var initData = (function(){
		return {
			/**
			 * 获取柱状图数据
			 */
			initChartDataFn:function(){
				$.getJSON('dataAnalyze!selectTaskCountByMonth.action',
					function(data) {
						if(-10000==data){
							location.href=location.href=$('#basePath').val();
						}
						var oneChartData = new Array(), twoChartData = new Array(), threeChartData = new Array();
						$(data).each(function(i) {
							/* 第一个柱状图数据为新建和运维打回的任务量 */
							oneChartData.push([data[i].settlement,
												data[i].newTask+ data[i].roll_back]);
							/* 第二个柱状图数据为待处理、处理中、运营打回的任务量 */
							twoChartData.push([data[i].settlement,data[i].pending+data[i].runRollback+
												data[i].processing]);
							/* 第三个柱状图数据为已处理和关闭的任务量 */
							threeChartData.push([data[i].settlement,
													data[i].processed + data[i].closed]);
						});
						/* 调用生成柱状图的方法 */
						chartLists.oneChart(oneChartData);
						chartLists.twoChart(twoChartData);
						chartLists.threeChart(threeChartData);
						/* 调用填充柱状图下数据表格的方法 */
						$('#js-table-tbody-1').html(chartLists.fillTableData(oneChartData));
						$('#js-table-tbody-2').html(chartLists.fillTableData(twoChartData));
						$('#js-table-tbody-3').html(chartLists.fillTableData(threeChartData));
					});
			},
			/**
			 * 获取曲线图数据
			 */
			initChartLineDataFn:function(settlement){
				if(''==settlement){
					settlement=$('#js-radios label').find('.checked input').val();
				}
				var year=$('#year').val();
				$.getJSON('dataAnalyze!selectTaskCountByYear.action',{"year":year,"settlement":settlement},
						function(data) {
					chartLine(data);
				});
			},
			/**
			 * 绑定事件
			 * 
			 * @returns
			 */
			boundEventFn:function(){
				/* 为单选框绑定选中事件 */
				$('#js-radios label').find('input').on('ifChanged',function(){
					initData.initChartLineDataFn($(this).val());
				});
				/* 为年份下拉绑定选中事件 */
				$('#year').on('change',function(){
					initData.initChartLineDataFn('');
				});
			},
			initYearAndSys:function(){
				$.ajax({
					url:'dataAnalyze!getYearAndSys.action',
					dataType:'json',
					type:'post',
					async:false,
					success:function(data) {
						if(-10000==data){
							location.href=$('#basePath').val();
						}else if(-1==data){
							alert('没有登录或登录超时');
						}else if(-2==data){
							alert('没有分配系统平台');
						}else{
							var html='';
							for(var i=0;i<data.year.length;i++){
								html+='<option value="'+data.year[i]+'">'+data.year[i]+'年</option>';
							}
							$('#year').html(html);
							html='';
							for(var i=0;i<data.sys.length;i++){
								html+='<label class=""><input type="radio" id="" name="chart-toggle" value="'+data.sys[i]+'">'+data.sys[i]+'</label>';
							}
							$('#js-radios').html(html);
							
							$('input[name="chart-toggle"]').iCheck({
		                        checkboxClass: 'icheckbox_flat-blue',
		                        radioClass   :'iradio_flat-blue'
		                    });
						}
					}
				});
			}
		};
	})();
	return {
		init : function() {
			initData.initYearAndSys();
			$('#js-radios label').find('input').first().iCheck('check');
			initData.initChartDataFn();
			initData.initChartLineDataFn('');
			initData.boundEventFn();
		}
	};
})(window, jQuery, document);