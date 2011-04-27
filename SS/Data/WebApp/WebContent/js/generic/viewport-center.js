/**
 * Copyright (c) Canadian Light Source, Inc. All rights reserved. - see
 * license.txt for details.
 *
 * Description:
 * 		viewport-center.js
 *
 */


var scanFilePanel = new Ext.ss.data.ScanFilePanel({
	fileListUrl:'scan/' + scanId + '/file/list.json',
	downloadUrl:'scan/' + scanId + '/file/download',
	style: {
		'margin':'20px'
	},
	border:false,
	height:400,
	width:800
});

var centerPanel = new Ext.Panel({
	region:'center',
	items: [ scanFilePanel ]
});