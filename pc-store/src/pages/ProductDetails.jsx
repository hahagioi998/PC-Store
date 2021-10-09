import React, { Component } from "react";
import Product from "../components/Product.jsx";
import Categories from "../components/Categories.jsx";
import Footer from "../components/Footer.jsx";

import { products } from "../DummyData/categories.js";

class ProductDetails extends Component {
  renderProductPage(name) {
    return (
      <Product product={products.find((product) => product.route === name)} />
    );
  }

  render() {
    const name = this.props.match.params.name;
    console.log(products.find((product) => product.route === name));

    return (
      <div>
        <React.Fragment>
          <div className="row">
            <div id="categories" className="col-md-2">
              <Categories />
            </div>
            <div id="page" className="col-md-10">
              {this.renderProductPage(name)}
            </div>
          </div>
          <Footer />
        </React.Fragment>
      </div>
    );
  }
}

export default ProductDetails;
