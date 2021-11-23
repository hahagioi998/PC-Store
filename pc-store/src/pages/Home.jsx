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
import AddProduct from "./AddProduct";

class Home extends Component {
  render() {
    return (
      <React.Fragment>
        <Intro />
        <div id="container" className="row">
          <div
            id="categories"
            className="col-lg-2 col-md-4 col-sm-12 mobile-margin visible-xs"
          >
            <Categories />
          </div>
          <div id="page" className="col-lg-10 col-md-8 col-sm-12">
            <Route exact path="/" component={Featured} />
            <Route exact path="/category/:categoryId" component={Category} />
            <Route exact path="/products/:id" component={ProductDetails} />
            <Route exact path="/search/:params" component={SearchResults} />
            <Route exact path="/AddProduct" component={AddProduct} />
          </div>
        </div>
        <Footer />
      </React.Fragment>
    );
  }
}

export default Home;
