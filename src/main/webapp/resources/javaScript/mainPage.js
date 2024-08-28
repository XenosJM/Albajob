/**
 * 
 */
 
 $(function(){
			
			/* const token = $("meta[name='_csrf']").attr("content");
        	const header = $("meta[name='_csrf_header']").attr("content");
        	const name = $("#userName").val();
        	
        	$.ajaxSetup({
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                }
            }); */
            
            $(document).on('click', '#memberLogin', function () {
                window.location.href = "login";
            });
            
		 	$(document).on('click', '#memberRegist', function () {
                window.location.href = "regist";
            });
		 	
		 	$(document).on('mouseover', '#additional-nav', function(){
		 		
		 	});
		 	
		 	
		})