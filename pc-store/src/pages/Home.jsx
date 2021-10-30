import React, { Component } from "react";
import Category from "./Category";
import ProductDetails from "./ProductDetails";
import Intro from "../components/Intro";
import Categories from "../components/Categories";
import Footer from "../components/Footer";
import { Route } from "react-router-dom";
import Featured from "./Featured";

import "./Home.css";
import SearchResults from "./SearchResults";

class Home extends Component {
  render() {
    return (
      <React.Fragment>
        <Intro />
        <div id="container" className="row">
          <div
            id="categories"
            className="col-lg-2 col-md-6 col-sm-12 mobile-margin visible-xs"
          >
            <Categories />
          </div>
          <div id="page" className="col-lg-10 col-md-6 col-sm-12">
            <Route exact path="/" component={Featured} />
            <Route exact path="/category/:categoryId" component={Category} />
            <Route exact path="/products/:id" component={ProductDetails} />
            <Route exact path="/search/:params" component={SearchResults} />
          </div>
        </div>
        <Footer />
      </React.Fragment>
    );
  }
}

export default Home;
