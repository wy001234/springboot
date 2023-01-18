/**
 * 
 */

 $(document).ready(function(){
				//user1 요청
				$('.user1_List1').click(function(){
					
					$.ajax({
						'url':'/Ch09/user1',
						'method':'get',
						'dataType':'json',
						'success':function(data){
							
							console.log(data);
						}
					})
					
				});
				
				//user1 목록 요청
				$('.user2_List1').click(function(){
					
					
					$.ajax({
						'url':'/Ch09/user1/r101',
						'method':'get',
						'dataType':'json',
						'success':function(data){
							
							console.log(data);
						}
					})
					
				});
				
				//user1 등록
				$('.user1_Register').click(function(){
					
					let jsonData = {
							"uid":"r101",
							"name":"홍길동",
							"hp":"010-1234-1234",
							"age":22
					}
					
					$.ajax({
						url:'/Ch09/user1',
						method:'POST',
						data: jsonData,
						dataType:'json',
						success:function(data){
							
							console.log(data);
						}
					})
					
				});
				
				//user1 수정
				$('.user1_Modify').click(function(){
					
					let jsonData = {
							"uid":"r101",
							"name":"홍길동",
							"hp":"010-1234-2222",
							"age":27
					}
					
					$.ajax({
						url:'/Ch09/user1',
						method:'PUT',
						data: jsonData,
						dataType:'json',
						success:function(data){
							
							console.log(data);
						}
					})
					
				});
				
				//user1 삭제
				$('.user1_Delete').click(function(){
					
					$.ajax({
						url:'/Ch09/user1/r101',
						method:'DELETE',
						dataType:'json',
						success:function(data){
							
							console.log(data);
						}
					})
					
				});
				
				
			});