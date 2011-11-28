package org.apache.jsp.WEB_002dINF.views.contacts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class contacts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write(" <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta name=\"Cache-Control\" content=\"no-cache\" />\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache\" />\n");
      out.write("<style>\n");
      out.write("\n");
      out.write("#composeMsg span{padding:2px 0px; font-weight:bold; }\n");
      out.write("#addressBlock{position:absolute;border:1px solid #bbb;\tmax-height:100px;overflow:auto;\tz-index:100;background-color:#ffffff;\tdisplay: none;width:98%;}\n");
      out.write("#addressBlock ul {margin:0px; list-style-type:none; padding:5px;  }\n");
      out.write("#addressBlock ul li {padding:5px 0px;margin:0px; width:100%}\n");
      out.write("#addressList{padding-bottom:5px;}\n");
      out.write("#addressList .cross {padding:0px 6px 0px 2px;font-weight:bold;color:#0000cc;text-decoration: none;}\n");
      out.write(".fullLengthInput{width:100%;display:block;height:21px; line-height:21px;border-top:1px solid #bbb;border-radius:6px;font-size: medium;}\n");
      out.write(".addressBtn {\n");
      out.write("background-color:#98d2ff;\n");
      out.write("border:1px solid #91ceff;\n");
      out.write("padding: 4px 8px;\n");
      out.write("margin:10px 0px;\n");
      out.write("font-family: \"Trebuchet MS\",Arial,Verdana,sans-serif;\n");
      out.write("font-size: 13px;\n");
      out.write("font-weight: bold;\n");
      out.write("cursor: pointer;\n");
      out.write("display: inline-block;\n");
      out.write("color: #444444;\n");
      out.write("background: url(\"http://localhost:8181/sangam/images/btn_aqua_active.gif\") repeat;\n");
      out.write("background-position: 0 50%;\n");
      out.write("\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form id=\"composeMsg\" action=\"sendfbinvite.do\" method=\"get\">\n");
      out.write("\t<div>\n");
      out.write("\t\t<span>Please enter the names of friends you want to email</span>\n");
      out.write("\t\t<div id=\"addressList\"></div>\n");
      out.write("\t\t<input type=\"text\" class=\"fullLengthInput\" onclick=\"this.value=''\" value=\"select a friend\" onkeyup=\"mbAddress.autoComplete(this)\" />\n");
      out.write("\t\t<div id=\"addressBlock\" onclick=\"mbAddress.attachHideEvent()\" ></div>\n");
      out.write("\t</div>\n");
      out.write("\t<input type=\"hidden\" value=\"\" name=\"userIds\" id=\"userIds\"  />\n");
      out.write("\t<div align=\"center\" style=\"padding:10px\">\n");
      out.write("\t\t<input class=\"addressBtn\" type=\"button\" value=\"Import\"  onclick=\"mbAddress.updateAddress()\" />&nbsp;&nbsp;\n");
      out.write("\t\t<input class=\"addressBtn\" type=\"button\" value=\"Close\" onclick=\"mbAddress.closePopup()\" />\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("<script>\n");
      out.write("\n");
      out.write("var mbAddress = {\n");
      out.write("\t\tfriends : function(){\n");
      out.write("\t\t\tvar showVar = '");
      if (_jspx_meth_c_005fout_005f0(_jspx_page_context))
        return;
      out.write("';\n");
      out.write("\t\t\treturn eval('(' + showVar + ')');\n");
      out.write("\t\t\t},\n");
      out.write("\t\tidStr:'',\n");
      out.write("\t\tgetObj:function (id){\t\t\n");
      out.write("\t\t\treturn document.getElementById(id);\n");
      out.write("\t\t},\n");
      out.write("\t\tautoComplete: function(field){\n");
      out.write("\t\t\tvar str='<ul id=\"addressess\">';\n");
      out.write("\t\t\tmbAddress.getObj('addressBlock').style.display = 'block';\n");
      out.write("\t\t\tfor(var i=0;i<mbAddress.friends().length;i++){\n");
      out.write("\t\t\t\tif(mbAddress.friends()[i].name.toLowerCase().indexOf(field.value.toLowerCase())!=-1){\n");
      out.write("\t\t\t\t\tstr+='<li onclick=\"mbAddress.addAddress(this)\" friendName=\"'+mbAddress.friends()[i].name+'\" id=\"'+mbAddress.friends()[i].id+'\"><input type=\"checkbox\" name=\"friends\" /><label>'+mbAddress.friends()[i].name+'</label></li>';\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tstr += '</ul>';\n");
      out.write("\t\t\tmbAddress.getObj('addressBlock').innerHTML = str;\n");
      out.write("\t\t\t\n");
      out.write("\t\t},\n");
      out.write("\t\taddAddress:function(field){\n");
      out.write("\t\t\t\tvar friendName = field.getAttribute('friendName');\n");
      out.write("\t\t\t\tvar id = field.getAttribute('id');\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tif(mbAddress.idStr.toLowerCase().indexOf(id)==-1){\n");
      out.write("\t\t\t\t\tmbAddress.getObj('addressList').innerHTML += '<span id=\"address'+id+'\">'+friendName+';<a href=\"javascript:void(0);\" onclick=\"mbAddress.removeAddress(\\''+id+'\\')\" class=\"cross\"><sup>X<sup></a></span>';\n");
      out.write("\t\t\t\t\tmbAddress.idStr += id+',';\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tmbAddress.getObj('addressess').removeChild(document.getElementById(id));\n");
      out.write("\t\t\t\tif(mbAddress.getObj('addressess').children.length<1){\n");
      out.write("\t\t\t\t\tmbAddress.getObj('addressBlock').style.display='none';\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\tmbAddress.setIdText();\n");
      out.write("\t\t},\n");
      out.write("\t\tremoveAddress:function(id){\n");
      out.write("\t\t\t rid = 'address'+ id;\n");
      out.write("\t\t\t mbAddress.getObj('addressList').removeChild(document.getElementById(rid));\n");
      out.write("\t\t\t mbAddress.idStr = mbAddress.idStr.split(id+',');\n");
      out.write("\t\t\t mbAddress.idStr =  mbAddress.idStr.join('');\n");
      out.write("\t\t\t mbAddress.setIdText();\n");
      out.write("\t\t},\n");
      out.write("\t\tsetIdText:function(){\n");
      out.write("\t\t\tmbAddress.getObj('userIds').value = mbAddress.idStr;\n");
      out.write("\t\t},\n");
      out.write("\t\thideAddressBlock:function(e){\n");
      out.write("\t\t\tvar hideflag = true;\n");
      out.write("\t\t\tif (!e) var e = window.event;\n");
      out.write("\t\t\tif(e.target.parentNode.id == 'addressess' || e.target.parentNode.parentNode.id == 'addressess'){\n");
      out.write("\t\t\t\thideflag = false;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\tif(hideflag){\n");
      out.write("\t\t\t\tmbAddress.getObj('addressBlock').style.display='none';\n");
      out.write("\t\t\t}\n");
      out.write("\t\t},\n");
      out.write("\t\tattachHideEvent: function(){\n");
      out.write("\t\t\tdocument.addEventListener('click',mbAddress.hideAddressBlock,false);\n");
      out.write("\t\t},\n");
      out.write("\t\tupdateAddress : function(){\n");
      out.write("\t\t\tvar emailIds=mbAddress.getObj('userIds').value;\n");
      out.write("\t\t\temailIds=emailIds.substring(0,emailIds.length-1);\n");
      out.write("\t\t\twindow.opener.setEmailList(emailIds);\n");
      out.write("\t\t\tself.close();\n");
      out.write("\t\t\twindow.opener.focus();\n");
      out.write("\t\t},\n");
      out.write("\t\tclosePopup : function() {\n");
      out.write("\t\t    self.close();\n");
      out.write("\t\t}\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fout_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent(null);
    // /WEB-INF/views/contacts/contacts.jsp(57,18) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jsonContacts}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    // /WEB-INF/views/contacts/contacts.jsp(57,18) name = escapeXml type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setEscapeXml(false);
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_005fvalue_005fescapeXml_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
