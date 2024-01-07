//Will path in index file once I know path
//<!--    Look up Thymeleaf hooks or perhaps API-->

document.getElementById("vacationCountdown").addEventListener("submit", function(event){
        event.preventDefault();
        countdownDate= dateInput.getTime();

        x= setInterval(function()) {

        today = new Date().getTime();

        howLong = countdownDate - today;

        days= Math.floor(distance / (1000 * 60 * 60 * 24));
        hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        seconds = Math.floor((distance % (1000 * 60)) / 1000);

        document.getElementById("countdownTimer").innerHTML = days + "days " + hours + "hours " + minutes + "minutes " + seconds + "seconds until trip!";

        if (howLong < 0) {
            clearInterval(x);
            document.getElementById("countdownTimer").innerHTML = "It's here!";
            }
        }
    }