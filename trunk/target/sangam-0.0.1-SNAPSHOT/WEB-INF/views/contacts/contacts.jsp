 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<style>

#composeMsg span{padding:2px 0px; font-weight:bold; }
#addressBlock{position:absolute;border:1px solid #bbb;	max-height:100px;overflow:auto;	z-index:100;background-color:#ffffff;	display: none;width:98%;}
#addressBlock ul {margin:0px; list-style-type:none; padding:5px;  }
#addressBlock ul li {padding:5px 0px;margin:0px; width:100%}
#addressList{padding-bottom:5px;}
#addressList .cross {padding:0px 6px 0px 2px;font-weight:bold;color:#0000cc;text-decoration: none;}
.fullLengthInput{width:100%;display:block;height:21px; line-height:21px;border-top:1px solid #bbb;border-radius:6px;font-size: medium;}
.addressBtn {
background-color:#98d2ff;
border:1px solid #91ceff;
padding: 4px 8px;
margin:10px 0px;
font-family: "Trebuchet MS",Arial,Verdana,sans-serif;
font-size: 13px;
font-weight: bold;
cursor: pointer;
display: inline-block;
color: #444444;
background: url("http://localhost:8181/sangam/images/btn_aqua_active.gif") repeat;
background-position: 0 50%;

}
</style>

</head>
<body>

<form id="composeMsg" action="sendfbinvite.do" method="get">
	<div>
		<span>Please enter the names of friends you want to email</span>
		<div id="addressList"></div>
		<input type="text" class="fullLengthInput" onclick="this.value=''" value="select a friend" onkeyup="mbAddress.autoComplete(this)" />
		<div id="addressBlock" onclick="mbAddress.attachHideEvent()" ></div>
	</div>
	<input type="hidden" value="" name="userIds" id="userIds"  />
	<div align="center" style="padding:10px">
		<input class="addressBtn" type="button" value="Import"  onclick="mbAddress.updateAddress()" />&nbsp;&nbsp;
		<input class="addressBtn" type="button" value="Close" onclick="mbAddress.closePopup()" />
	</div>
</form>
<script>

var mbAddress = {
		friends : function(){
			var showVar = '<c:out value="${jsonContacts}" escapeXml="false"/>';
			return eval('(' + showVar + ')');
			},
		idStr:'',
		getObj:function (id){		
			return document.getElementById(id);
		},
		autoComplete: function(field){
			var str='<ul id="addressess">';
			mbAddress.getObj('addressBlock').style.display = 'block';
			for(var i=0;i<mbAddress.friends().length;i++){
				if(mbAddress.friends()[i].name.toLowerCase().indexOf(field.value.toLowerCase())!=-1){
					str+='<li onclick="mbAddress.addAddress(this)" friendName="'+mbAddress.friends()[i].name+'" id="'+mbAddress.friends()[i].id+'"><input type="checkbox" name="friends" /><label>'+mbAddress.friends()[i].name+'</label></li>';
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
			var emailIds=mbAddress.getObj('userIds').value;
			emailIds=emailIds.substring(0,emailIds.length-1);
			window.opener.setEmailList(emailIds);
			self.close();
			window.opener.focus();
		},
		closePopup : function() {
		    self.close();
		}
}

</script>


</body>

</html>



