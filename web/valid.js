 $(document).ready(function(){
                
                var form = $("#contactform");
                var name = $("#name");
                var email = $("#email");
                var pass1 = $("#pass1");
                var pass2 = $("#pass2");
                var nameinfo =$("#nameinfo");
                var emailinfo = $("#emailinfo");
                var pass1info = $("#pass1info");
                var pass2info = $("#pass2info");
                
                name.blur(validateName());
                name.blur(validateEmail());
                
                form.submit(function (){
                
                    if(validateName() & validateEmail() & validatePass1() & validatePass2()){
                        
                        return true;
                    }
                    else{
                        return false;
                    }
                    
                    
                    
                });
                
                function validateName(){
                    
                    if(name.val().length < 3){
                        
                        name.addClass("error");
                        nameinfo.text ="Karakter sayisi cok az..";
                        nameinfo.addClass("error");
                        return false;
                    }
                    else{
                        
                        name.removeClass("error");
                        nameinfo.text("Whats your name?");
                        nameinfo.removeClass("error");
                        return true;
                        
                    }
                }
                function validateEmail(){
                    var regexp = "[a-zA-Z0-9._+]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}";
                    var a =$("#email").val();
                    
                    if(filter.text(a)){
                        
                        email.removeClass("error");
                        emailinfo.removeClass("error");
                        emailinfo.text="Size geri donus yapabilmemiz icin yaziniz";
                        
                    }
                    else{
                        
                        email.addClass("error");
                        emailinfo.addClass("error");
                        emailinfo.text="Gecerli bir adres giriniz";
                    }
                    
                }
                
            });

