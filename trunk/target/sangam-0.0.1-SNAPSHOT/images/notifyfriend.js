var mbAddress = {
			friends: {
			  "data": [
					{
						  "name": "Jansan John", 
						  "id": "abcya@oo.com"
					}, 
					{
						  "name": "Claudia Suarez", 
						  "id": "clau@oo.com"
					}, 
					{
						  "name": "Jagannath Rai", 
						  "id": "jaga@oo.com"
					}, 
					{
						  "name": "Abhijeet Mense", 
						  "id": "Abhi@oo.com"
					}, 
					{
						  "name": "Pavithra Kodmad", 
						  "id": "pavi@oo.com"
					}
				]
			}
			,
			idStr:'',
			getObj:function (id){		
				return document.getElementById(id);
			},
			autoComplete: function(field){
				var str='<ul id="addressess">';
				mbAddress.getObj('addressBlock').style.display = 'block';
				for(var i=0;i<mbAddress.friends.data.length;i++){
					if(mbAddress.friends.data[i].name.toLowerCase().indexOf(field.value.toLowerCase())!=-1){
						str+='<li onclick="mbAddress.addAddress(this)" friendName="'+mbAddress.friends.data[i].name+'" id="'+mbAddress.friends.data[i].id+'"><input type="checkbox" name="friends" /><label>'+mbAddress.friends.data[i].name+'</label></li>';
					}
				}
				str += '</ul>';
				mbAddress.getObj('addressBlock').innerHTML = str;
				
			},
			addAddress:function(field){
					var friendName = field.getAttribute('friendName');
					var id = field.getAttribute('id');
					
					if(mbAddress.idStr.toLowerCase().indexOf(id)==-1){
						mbAddress.getObj('addressList').innerHTML += '<span id="address'+id+'">'+friendName+';<a href="javascript:void(0);" onclick="mbAddress.removeAddress(\''+id+'\')" class="cross"><sup>X<sup></a></span>';
						mbAddress.idStr += id+',';
					}
					mbAddress.getObj('addressess').removeChild(document.getElementById(id));
					if(mbAddress.getObj('addressess').children.length<1){
						mbAddress.getObj('addressBlock').style.display='none';
					}
				mbAddress.setIdText();
			},
			removeAddress:function(id){
				 rid = 'address'+ id;
				 mbAddress.getObj('addressList').removeChild(document.getElementById(rid));
				 mbAddress.idStr = mbAddress.idStr.split(id+',');
				 mbAddress.idStr =  mbAddress.idStr.join('');
				 mbAddress.setIdText();
			},
			setIdText:function(){
				mbAddress.getObj('userIds').value = mbAddress.idStr;
			},
			hideAddressBlock:function(e){
				var hideflag = true;
				if (!e) var e = window.event;
				if(e.target.parentNode.id == 'addressess' || e.target.parentNode.parentNode.id == 'addressess'){
					hideflag = false;
					}
				if(hideflag){
					mbAddress.getObj('addressBlock').style.display='none';
				}
			},
			attachHideEvent: function(){
				document.addEventListener('click',mbAddress.hideAddressBlock,false);
			},
			updateAddress : function(){
			    self.close();
				window.opener.setEmailList(mbAddress.getObj('userIds').value);
				window.opener.focus();
			},
			closePopup : function() {
			    self.close();
			}
	}