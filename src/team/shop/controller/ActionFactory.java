package team.shop.controller;

import team.shop.controller.action.Action;  
import team.shop.controller.action.CartDelete;
import team.shop.controller.action.CartInsert;
import team.shop.controller.action.CartList;
import team.shop.controller.action.CartPayment;
import team.shop.controller.action.CategoryDetailAction;
import team.shop.controller.action.IdCheckAction;
import team.shop.controller.action.IndexAction;
import team.shop.controller.action.InsertOrder;
import team.shop.controller.action.InsertReview;
import team.shop.controller.action.JoinAction;
import team.shop.controller.action.JoinContractAction;
import team.shop.controller.action.JoinFormAction;
import team.shop.controller.action.LoginAction;
import team.shop.controller.action.LoginFormAction;
import team.shop.controller.action.LogoutAction;
import team.shop.controller.action.MyPage1Action;
import team.shop.controller.action.MyPage3Action;
import team.shop.controller.action.MyPage3_1_moveAction;
import team.shop.controller.action.MyPage3_2_checkAction;
import team.shop.controller.action.MyPage4_1_updateAction;
import team.shop.controller.action.MyPage5Action;
import team.shop.controller.action.MyPage6Action;
import team.shop.controller.action.MyPage7Action;
import team.shop.controller.action.Payment;
import team.shop.controller.action.ProductDetailAction;
import team.shop.controller.action.ReviewAction;
import team.shop.controller.action.SearchAction;
import team.shop.controller.action.WriteReviewFormAction;
import team.shop.controller.action.askAction;
import team.shop.controller.action.deleveryAction;
import team.shop.controller.action.etcAction;
import team.shop.controller.action.mtmDeleteAction;
import team.shop.controller.action.mtmUpdate;
import team.shop.controller.action.mtmUpdateForm;
import team.shop.controller.action.mtmWriteAction;
import team.shop.controller.action.orderPaymentAction;
import team.shop.controller.action.productInquiryAction;
import team.shop.controller.action.questionAction;
import team.shop.controller.action.returnAction;
import team.shop.controller.action.savingAction;
import team.shop.controller.admin.action.AdminCategoryList;
import team.shop.controller.admin.action.AdminDeleteAction;
import team.shop.controller.admin.action.AdminLoginAction;
import team.shop.controller.admin.action.AdminLoginFormAction;
import team.shop.controller.admin.action.AdminMainAction;
import team.shop.controller.admin.action.AdminMtmList;
import team.shop.controller.admin.action.AdminMtmOneList;
import team.shop.controller.admin.action.AdminMtmUpdateAction;
import team.shop.controller.admin.action.AdminProductInsert;
import team.shop.controller.admin.action.AdminProductInsertForm;
import team.shop.controller.admin.action.AdminReviewCall;
import team.shop.controller.admin.action.AdminReviewDelete;
import team.shop.controller.admin.action.AdminReviwReplyUpdate;
import team.shop.controller.admin.action.AdminSearch;
import team.shop.controller.admin.action.AdminUpdateAction;
import team.shop.controller.admin.action.AdminUpdateFormAction;
import team.shop.controller.admin.action.Admin_mtmList_Action;
import team.shop.controller.admin.action.admin_memberDeleteAction;
import team.shop.controller.admin.action.admin_memberDetailUpdateAction;
import team.shop.controller.admin.action.admin_memberDetailViewAction;
import team.shop.controller.admin.action.admin_memberListsearchAction;
import team.shop.controller.admin.action.admin_memberListselectAction;

public class ActionFactory {
	//싱글톤 형태로 유일하게 한 개의 객체만 생성하고 getInstance()로 호출해 사용함
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	public static ActionFactory getInstance() {
		return instance;
	}
	//Servlet에서 받아온 command에 맞는 액션객체를 찾아 Servlet으로 전달
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : "+command);
		
		if(command.equals("category_list")) {
			action = new CategoryDetailAction();
		}else if(command.equals("product_detail")){
			action = new ProductDetailAction();
		}else if(command.equals("search")) {
			action = new SearchAction();
		}else if(command.equals("index")) {
			action = new IndexAction();
		}else if(command.equals("log_in")) {
			action = new LoginAction();
		}else if(command.equals("login_form")) {
			action = new LoginFormAction();
		}else if(command.equals("join_contract")) {
			action = new JoinContractAction();
		}else if(command.equals("join_form")) {
			action = new JoinFormAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("id_check")) {
			action = new IdCheckAction();
		}else if(command.equals("logout")){
			action = new LogoutAction();
		}else if(command.equals("review")) {
			action = new ReviewAction();
		}else if(command.equals("mypage_1")) {
			action = new MyPage1Action();
		}else if(command.equals("mypage_2")) {
			action = new WriteReviewFormAction();
		}else if(command.equals("mypage3_1_moveAction")) {
			action = new MyPage3_1_moveAction();
		}else if(command.equals("mypage3_2_checkAction")) {
			action = new MyPage3_2_checkAction();
		}else if(command.equals("mypage4_1_updateAction")) {
			action = new MyPage4_1_updateAction();
		}else if(command.equals("mypage_5")) {
			action = new MyPage5Action();
		}else if(command.equals("mypage_6")) {
			action = new MyPage6Action();
		}else if(command.equals("mypage_7")) {
			action = new MyPage7Action();
		}else if(command.equals("ask")) {
			action = new askAction();
		}else if(command.equals("question_main")) {
			action = new questionAction();
		}else if(command.equals("product_inquiry")) {
			action = new productInquiryAction();
		}else if(command.equals("order_payment")) {
			action = new orderPaymentAction();
		}else if(command.equals("delivery")) {
			action = new deleveryAction();
		}else if(command.equals("return")) {
			action = new returnAction();
		}else if(command.equals("saving")) {
			action = new savingAction();
		}else if(command.equals("etc")) {
			action = new etcAction();
		}else if(command.equals("mtm")) {
			action = new mtmWriteAction();
		}else if(command.equals("mtmUpdate")){
			action = new mtmUpdate();
		}else if(command.equals("mtmUpdateForm")) {
			action = new mtmUpdateForm();
		}else if(command.equals("mtmDelete")) {
			action = new mtmDeleteAction();
		}else if(command.equals("payment")) {
			action = new Payment();
		}else if(command.equals("insert_order")) {
			action = new InsertOrder();
		}else if(command.equals("insert_review")) {
			action = new InsertReview();
		}else if(command.equals("cart_insert")) {
			action = new CartInsert();
		}else if(command.equals("cart_list")) {
			action = new CartList();
		}else if(command.equals("cart_delete")) {
			action = new CartDelete();
		}else if(command.equals("cart_payment")) {
			action = new CartPayment();
		}
		
		
			
		//admin Action
		else if(command.equals("admin_loginForm")) {
			action = new AdminLoginFormAction();
		}else if(command.equals("admin_login")) {
			action = new AdminLoginAction();
		}else if(command.equals("admin_main")) {
			action = new AdminMainAction();
		}else if(command.equals("admin_product_UpdateForm")) {
			action = new AdminUpdateFormAction();
		}else if(command.equals("admin_pUpdate")) {
			action = new AdminUpdateAction();
		}else if(command.equals("admin_pDelete")) {
			action = new AdminDeleteAction();
		}else if(command.equals("admin_category_list")) {
			action = new AdminCategoryList();
		}else if(command.equals("admin_memberList")) {
			action = new admin_memberListselectAction();
		}else if(command.equals("admin_memberListsearch")) {
			action = new admin_memberListsearchAction();
		}else if(command.equals("admin_memberDetail")) {
			action = new admin_memberDetailViewAction();
		}else if(command.equals("admin_memberDetailUpdate")) {
			action = new admin_memberDetailUpdateAction();
		}else if(command.equals("admin_memberDelete")) {
			action = new admin_memberDeleteAction();
		}else if(command.equals("admin_mtmList")) {
			action = new AdminMtmList();
		}else if(command.equals("Admin_mtmList")) {
	         action = new Admin_mtmList_Action();
	     }else if(command.equals("Admin_mtm_one_list")) {
			action = new AdminMtmOneList();
		}else if(command.equals("Admin_mtm_reply_update")) {
			action = new AdminMtmUpdateAction();
		}else if(command.equals("admin_review_call")) {
			action = new AdminReviewCall();
		}else if(command.equals("admin_review_delete")) {
			action = new AdminReviewDelete();
		}else if(command.equals("insert_rReply")) {
			action = new AdminReviwReplyUpdate();
		}else if(command.equals("admin_pInsertForm")) {
			action = new AdminProductInsertForm();
		}else if(command.equals("admin_pInsert")) {
			action = new AdminProductInsert();
		}else if(command.equals("admin_search")) {
			action = new AdminSearch();
		}
		//command에 해당하는 Action을 Servlet으로 리턴해줌
		return action;
	}
	
}
