import React from "react";
import Footer from "./Footer";
import Icon from "./Icon";
import "./Home.css"
const Home = () => {
  return (
    <div className="container">

      <div className="main">
        <div className="motto">
          <h3>
            We as a Bank provide a pathway between
            <br /> <span>You and Your Dream</span>.
          </h3>
        </div>
        {/* <div className="logo">
          <img
            src="https://th.bing.com/th/id/OIP.LLrZK0rK-iikIzIKE9kGZAHaE-?pid=ImgDet&rs=1"
            alt=""
          />
        </div> */}
      </div>

      <div className="footer">
        {/* <h4>Created with &hearts; by &#169; Jatin Bhargava 2023 </h4> */}
      </div>
      <Footer />
      <Icon />
    </div>
  );
};

export default Home;