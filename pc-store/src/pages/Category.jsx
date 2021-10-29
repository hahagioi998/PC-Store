import React, { Component } from "react";
import Product from "../components/Product";

class Category extends Component {
  constructor(props) {
    super(props);
    this.categoryId = this.props.match.params.categoryId;
    this.state = {
      products: [],
    };
  }

  componentDidMount() {
    this.fetchData();
  }

  componentDidUpdate(prevProps) {
    if (
      this.props.match.params.categoryId !== prevProps.match.params.categoryId
    ) {
      this.categoryId = this.props.match.params.categoryId;
      this.fetchData();
    }
  }

  fetchData() {
    console.log(this.categoryId);
    fetch("http://localhost:8080/api/categories/" + this.categoryId)
      .then((data) => data.json())
      .then((json) => {
        this.setState({
          products: json,
        });
      })
      .catch(function (ex) {
        console.log("Error:", ex);
      });
  }

  renderProductsFromCategory(id) {
    return this.state.products
      .filter((prod) => prod.category.id == id)
      .map((prod, i) => {
        return <Product key={i} product={prod} />;
      });
  }

  render() {
    return (
      <div className="row">
        {this.renderProductsFromCategory(this.categoryId)}
      </div>
    );
  }
}

export default Category;
