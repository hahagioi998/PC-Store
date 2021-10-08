import React, { Component } from "react";
import { products } from "../DummyData/categories.js";
import Product from "../components/Product";
import Categories from "../components/Categories.jsx";
import Footer from "../components/Footer.jsx";

class Category extends Component {
  renderProductsFromCategory(name) {
    return products
      .filter((prod) => prod.category === name)
      .map((prod, i) => {
        return (
          <span key={i}>
            <Product product={prod} />
          </span>
        );
      });
  }

  render() {
    const name = this.props.match.params.name;

    return (
      <div>
        <React.Fragment>
          <div className="row">
            <div id="categories" className="col-md-3">
              <Categories />
            </div>
            <div id="page" className="col-md-9">
              {this.renderProductsFromCategory(name)}
            </div>
          </div>
          <Footer />
        </React.Fragment>
      </div>
    );
  }
}

export default Category;
