function unEdit(){
	$("input").attr('readonly', true);
	$("input[type='submit']").css('visibility', "hidden");
	$("textarea").attr('readonly', true);
	$(':radio').attr('disabled', true);
	$(':checkbox').attr('disabled', true);
	$(':button').attr('disabled', true);
	$('a').removeAttr('onclick');
	$('select').attr('disabled', true);
}