
var prefix = "/restAjax";

var RestGet = function() {
	
    $.ajax({
        type: 'GET',
        url:  prefix + "/MyData/" + Date.now(),
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("At " + result.time + ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
        	alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}

var RestPut = function() {
	
	var JSONObject= {
		"time": Date.now(),
		"message": "LM PUT call !!!"
	};
	
    $.ajax({
        type: 'PUT',
        url:  prefix + "/MyData",
		contentType: "application/json; charset=utf-8",		
		data: JSON.stringify(JSONObject),
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("At " + result.time + ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}

var RestPutSerie = function() {
	
	var JSONObject= {
		"origin": "YUL",
		"destination": "YYZ",
		"milesByStanding":"132545, 45122"
	};
	
    $.ajax({
        type: 'PUT',
        url:  prefix + "/MyData/serie",
		contentType: "application/json; charset=utf-8",		
		data: JSON.stringify(JSONObject),
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("Serie: " + result.origin + ": " + result.milesByStanding);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}

var RestPost = function() {
	
    $.ajax({
        type: 'POST',
        url:  prefix + "/MyData",
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("LM " + result.time
				+ ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}

var RestDelete = function() {
	
    $.ajax({
        type: 'DELETE',
        url:  prefix + "/MyData/" + Date.now(),
		dataType: 'json',
        async: true,
        success: function(result) {
			alert("At " + result.time
				+ ": " + result.message);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}