import React, { Component } from "react";
import Category from "./Category";
import ProductDetails from "./ProductDetails";
import Intro from "../components/Intro";
import Categories from "../components/Categories";
import Footer from "../components/Footer";
import { Route } from "react-router-dom";
import Featured from "./Featured";

import "./Home.css";

class Home extends Component {
  render() {
    return (
      <React.Fragment>
        <Intro />
        <div id="container" className="row">
          <div id="categories" className="col-lg-2 col-md-6 col-sm-12">
            <Categories />
          </div>
          <div id="page" className="col-lg-10 col-md-6 col-sm-12 border">
            <Route exact path="/" component={Featured} />
            <Route exact path="/category/:name" component={Category} />
            <Route
              exact
              path="/product-details/:name"
              component={ProductDetails}
            />
          </div>
        </div>
        <Footer />
      </React.Fragment>
    );
  }
}

export default Home;
