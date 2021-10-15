import React, { Component } from "react";
import { products } from "../DummyData/categories.js";
import Product from "../components/Product";
import "./Featured.css";

class Featured extends Component {
  render() {
    const featuredProducts = products
      .filter((l) => l.isFeatured === true)
      .map((l, i) => {
        return (
          <span key={i} className="featured-product-showcase">
            <Product product={l} />
          </span>
        );
      });

    return (
      <div id="featured-items-container" className="border">
        {featuredProducts}
      </div>
    );
  }
}

export default Featured;
