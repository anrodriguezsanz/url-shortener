$(document).ready(function(){

    $("#submit-btn").click(function(event) {
        event.preventDefault();
        
        const originalUrl = $("#original-url").val();
        
        // Make an asynchronous POST request to the server
        $.post("/", { "original-url": originalUrl }, function(data) {
            // 'data' contains the shortened URL returned by the controller
            
            // Update the DOM with the result
            $("#shortened-link").attr("href", data);
            $("#shortened-link").text(data);
            $("#result-container").fadeIn();
        }).fail(function() {
            alert("Error shortening the URL");
        });
    });
});