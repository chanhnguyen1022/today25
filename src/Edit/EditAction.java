/**
 *@author chanh-nm,
 * @(#)Connect database .java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 * Version 1.1.
 */
package Edit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import search.CustomerDAO;

public class EditAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("toi");
		HttpSession session = request.getSession();
		CustomerDAO dao = new CustomerDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = (String) session.getAttribute("username");
		EditForm editForm = (EditForm) form;
		int PSN_CD = dao.getPSNCDbyUsername(name);
		editForm.setUpdatePSN(PSN_CD);
		editForm.setUserid(id);
		dao.EditCustomer(editForm);
		return mapping.findForward("result");

	}
}