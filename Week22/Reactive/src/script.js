window.onscroll = function () {
    scrollFunction();
  };
  
  // Function to change navigation bar's background color
  function scrollFunction() {
    if (
      document.body.scrollTop > 509.5 ||
      document.documentElement.scrollTop > 509.5
    ) {
      document.querySelector("nav").style.backgroundColor = "#355592";
    } else {
      document.querySelector("nav").style.backgroundColor = "transparent";
    }
  }