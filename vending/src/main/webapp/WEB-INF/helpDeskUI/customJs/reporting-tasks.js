var ReportingTasks = (function (){
    'use strict';
   var infoScorll = function (){
        App.$content.find('.task-info-scorll').slimScroll({
         //滚动条滚动到顶部或底部时是否允许页面滚动,默认false
          allowPageScroll: false,
          size: '6px',
          railVisible:false,
          // 滚动条距离位置
          distance:'0',
          railColor:'#000',
          
          alwaysVisible: false,
          //滚动条背景轨迹透明度,默认0.2
          // railOpacity: 0.2,
          height: '490'
        });
   };
   var timeRange = function (){
        if (!$().datepicker) {
            throw new Error('datepickerModule 方法: 依赖 jquery-ui.js');
        }

        
        var $form = $('#js-date-star'), $to   = $('#js-date-end');

         $form.datepicker({
               changeMonth : true,
               changeYear : true,
              
               numberOfMonths : 1,
               showOn:  'button',
               buttonImageOnly: true,
               buttonText: '选择开始时间',
               onClose : function(selectedDate) {
                       $to.datepicker("option", "minDate", selectedDate);
               }
          });   
        
            
            $to.datepicker({
               changeMonth : true,
               changeYear : true,
               numberOfMonths : 1,
                showOn:  'button',
               buttonImageOnly: true,
               buttonText: '选择结束时间',
               onClose : function(selectedDate) {
                       $form.datepicker("option", "maxDate", selectedDate);
               }
          });
    };
    return {
        init: function (){
            infoScorll();
             timeRange();
        },
        addFileInput: function ( id ) {

            if( id.length && typeof id === 'string' ) { 
                $(id).on('click', '.btn.btn-default', function (event){
                    var $this = $(this);
                    var html = '<input type="file" class="margin-bottom-lg">';
                    
                    if( $this.parent().children('input').size() == 4 ) {
                        $this.attr('disabled', true);
                    } else {
                        $this.prev().after(html);
                    }
                });
            };
        },
        addDialog: function (){
            if(!$().dialog){
                 throw new Error('addDialog 方法: 依赖 jquery-ui.js'); 
            }
            var $dialog = $('#js-add-dialog'),
                $btn    = $('#js-add-btn'),
                $form   = $dialog.find('form');

            $dialog.dialog({
                autoOpen: false,
                height: 460,
                width: 720,
                maxWidth: 720,
                modal: true,
                title: '新增',
                buttons: {
                    '确定': function() {
                        // $form.serialize()
                        $dialog.dialog( 'close' );
                    },
                    '关闭': function() {
                       $dialog.dialog('close');
                    }
                }
            });

            $btn.on('click', function(){
                $dialog.dialog('open');
            });
        }
    };
})();