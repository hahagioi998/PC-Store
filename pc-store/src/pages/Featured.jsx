import React, { Component } from "react";
import { products } from "../DummyData/categories.js";
import Product from "../components/Product";

//import "../components/shared.css";
import "./Featured.css";

class Featured extends Component {
  render() {
    const featuredProducts = products
      .filter((l) => l.isFeatured === true)
      .map((l, i) => {
        return <Product key={i} product={l} />;
      });

    return <div className="row">{featuredProducts}</div>;
  }
}

export default Featured;
