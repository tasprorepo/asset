   
function toggleMenu(btnobj)
{
	if($('#sidemenuHdrTr').is(':visible'))
	{		
		$("#sidemenuHdrTr").hide();
		btnobj.innerHTML = "&nbsp;&gt&nbsp;";
		document.getElementById("overflowdiv").style.width="1200px";
	}//end of if
	else
	{
		$("#sidemenuHdrTr").show();
		btnobj.innerHTML = "&nbsp;&lt&nbsp;";
		document.getElementById("overflowdiv").style.width="1200px";
	}   //end of else 
}//end of toggleMenu                       