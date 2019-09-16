/**
 * 
 */

var CONSTANTS_VAR = 
  {
	
	// MODES
	INSERT_MODE : 'I',
	QUERY_MODE  : 'Q',
	DELETE_MODE : 'D',
	UPDATE_MODE : 'U',
	
	
	
	// Select Row Before Delete!
	ADDROW_BFR_EDIT   : 'Add Row Before Edit',
	ADDROW_BFR_DEL   : 'Add Row Before Delete',
	SELROW_BFR_DEL   : 'Select Row Before Delete',
    SEL_ANYSRCH_CRIT : 'Select any of the search criteria',
    NO_ROWS:'No Rows Found',
    NO_ROWS_EXPORT:'Records Not Found To Export',	
   // Validations
    KEYIN_HRDWRE_NAME   :'Please keyin Hardware Name',
    KEYIN_ASSET_NAME  :'Please keyin Asset Name',
    KEYIN_SERIAL_NO: 'Please keyin Serial No',
    KEYIN_OS: 'Please keyin Operating System ',
    KEYIN_PROSSR_NAME :'Please keyin Processor Name',
    KEYIN_SERVICE_TYPE :'Please keyin ServiceType',
    KEYIN_PURCHASE_DATE :'Please keyin Purchase Date',
    KEYIN_VALIDIDITY_PERIOD :'Please keyin Validity Period',
    KEYIN_PRODUCT_NAME :'Please keyin Product Name',
    KEYIN_SUBPRODUCT_NAME :'Please keyin SubProduct Name',
    NO_RECORDS        :'No Record(s) to clear',
    KEYIN_SOFTWRE_ID   :'Please keyin Software ID',
    KEYIN_SOFTWRE_NAME :'Please keyin Software Name',
    KEYIN_SOFTWRE_LIC :'Please keyin License Key',
    KEYIN_SOFTWRE_CATEG :'Please keyin Software Category',
    //Validation for ServiceTracking
    KEYIN_HD_NAME       : 'Please keyin Hardware Name',
    KEYIN_SW_NAME       : 'Please Keyin Software Name',
    KEYIN_VD_REP		: 'Please Keyin Vendor Name',
    KEYIN_VD_NAME       : 'Please Keyin Vendor Name',
    KEYIN_VD_EMAIL       : 'Please Keyin Vendor Email',
    KEYIN_SERVC_REQ     : 'Please Keyin Service Request',
    KEYIN_SERVC_DATE    : 'Please Keyin Service Date',
    KEYIN_VD_CONTACT247 :'Please Keyin Contact 24/7',
    KEYIN_VD_KEYPERSON_NAME:'Please Keyin Key Person Name',
    KEYIN_VD_DIRECT_NO	:'Please Keyin Direct No',
    ADDROW_BFR_SMT      : 'Add Row Before Submit',
    
    KEYIN_ATTCK_CATG : 'Please Keyin Attachment Category',
	KEYIN_DOCTYPE : 'Please Keyin Document Type',
	KEYIN_DOCTITLE : 'Please Keyin Document Title',
	KEYIN_DOCUPLOAD:'Please Upload a File',
    ENABLE            : 'ENABLE',
    DISABLE           : 'DISABLE'
  };




var ASSET_SCREENS = 
   {
		
		ASSETHARD:'Asset Hardware Details^This is About Asset Hardware Details',
		ASSETSOFT:'Asset Software Details^This is About Asset Software Details',
		ASSETVENDOR:'Vendor Details^This is About Asset Vendor Details',
		SERVICETRACK:'Servive Tracking Details^This is About Service Tracking Details',
		RENEWALREMAIND:'Renewal Remainder Details^This is About Renewal Remainder Details',
		ASSETATTACHMENTS:'Asset Attachments Details^This is About Asset Attachments Details',
		ABOUT:'About^This is About the Application',
		MYACC:'My Account^This is for Account Settings',
		HELP:'Help This is About Help'
  };