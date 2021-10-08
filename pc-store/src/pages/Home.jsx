import React, { Component } from "react";
import Categories from "../components/Categories";
import Intro from "../components/Intro";
import Featured from "../components/Featured";
import Footer from "../components/Footer";
import "./Home.css";

class Home extends Component {
  render() {
    return (
      <React.Fragment>
        <Intro />
        <div className="row">
          <div id="categories" className="col-md-2">
            <Categories />
          </div>
          <div id="page" className="col-md-10">
            <Featured />
          </div>
        </div>
        <Footer />
      </React.Fragment>
    );
  }
}

export default Home;
