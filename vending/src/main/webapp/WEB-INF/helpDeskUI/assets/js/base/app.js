/*
* @Author     : lilonglong
* @Date       : 2015/08/06
* @Version    : 0.1.0
* @Description: 运维平台
* @Dependence : jQuery
* @Mail       : long_mailbox@sina.com
* @Reference  : http://codeguide.bootcss.com/
************************************************
************************************************
*/
var App = (function (window, $, document, undefined) {
   'use strict';
    // all ie
    var isIE = document.all && !!window.ActiveXObject;
    // >= ie8
    var isIE8 = isIE && !document.addEventListener;
    var $body = $('body');

    var sidebarScroll = function (){
        $('.sidebar-inner').slimScroll({
          allowPageScroll: false,
          size: '6px',
          height: '100%'
        });
    };

    
    // 对外公开的方法和属性
    return {
        isIE8: isIE8,
        $body: $body,
        $page: $body.find('.pages'),
        $sidebar: $body.find('.page-sidebar'),
        $content: $body.find('.page-content'),
        $footer: $body.find('.page-footer'),
        $heading: $body.find('.page-heading'),
        $breadcrumb: $body.find('.page-breadcrumb'),
        stopDefaultEvent: function (){
            $body.find('a[href^="#"]').on('click', function(event){
                event.preventDefault();
            });
        },
        sidebarScroll: sidebarScroll,
        icheckForm: function (checkAll){
            var $parent = $body.find('.js-icheck');
            var allInput = $parent.find('input');


            $.each(allInput, function (i, ele){
                var isCheckbox = (ele.type === 'checkbox' ? true : false);
                var isRaido    = (ele.type === 'radio'    ? true : false); 

                if(  isCheckbox ||  isRaido ){
                    $(ele).iCheck({
                        checkboxClass: 'icheckbox_flat-blue',
                        radioClass   :'iradio_flat-blue'
                    });
                } else {
                    return;
                }
            });
            // if(arguments.length && !!checkAll) {
            //     if( $parent.find('.js-check-all').attr('checked', true) ){
            //         $parent.find('input').attr('checked', true);
            //     } else {
            //         $parent.find('input').attr('checked', false);
            //     }
            // }
        },
        pageLoadBar: function (){ 
            if( isIE8 ) {
               return false;
            }
            NProgress.configure({ easing: 'ease', speed: 2000 });
            NProgress.start();
            NProgress.done();
        }
   };
})(window, jQuery, document);