import React, { Component } from "react";
import axios from "axios";

class AddProduct extends Component {
  constructor(props) {
    super(props);

    this.state = {
      categories: [],
      product: {
        name: "",
        description: "",
        price: "",
        category: "",
        manufacturer: "",
        image: null,
      },
    };
  }

  renderOptions() {
    return this.state.categories.map((category, i) => {
      return (
        <option key={i} value={category.id} name="category">
          {category.name}
        </option>
      );
    });
  }

  componentDidMount() {
    fetch("http://192.168.1.149:8080/api/categories")
      .then((data) => data.json())
      .then((json) => {
        this.setState({
          categories: json,
        });
        this.setState({
          product: {
            ...this.state.product,
            category: json[0].id,
          },
        });
      })
      .catch(function (ex) {
        console.log("Error:", ex);
      });
  }

  handleSubmit(event) {
    console.log(this.state.product);
    axios
      .post("http://192.168.1.149:8080/api/products/add", this.state.product)
      .then((response) => console.log(response))
      .catch((error) => console.log(error));
  }

  handleChange(event) {
    this.setState({
      product: {
        //if i only change the target, the rest of the properties get deleted
        ...this.state.product,
        [event.target.name]: event.target.value,
      },
    });
  }

  render() {
    return (
      <div>
        <form method="POST" onSubmit={(evt) => this.handleSubmit(evt)}>
          <label id="name" htmlFor="name">
            Name:
          </label>
          <input
            type="text"
            name="name"
            value={this.state.product.name}
            onChange={(evt) => this.handleChange(evt)}
          />
          <br />

          <label id="description" htmlFor="description">
            Description:
          </label>
          <textarea
            rows="5"
            name="description"
            value={this.state.product.description}
            onChange={(evt) => this.handleChange(evt)}
          />
          <br />

          <label id="price" htmlFor="price">
            Price:
          </label>
          <input
            type="text"
            name="price"
            value={this.state.product.price}
            onChange={(evt) => this.handleChange(evt)}
          />
          <br />

          <label id="category" htmlFor="category">
            Category:
          </label>
          <select
            type="select"
            name="category"
            onChange={(evt) => this.handleChange(evt)}
          >
            {this.renderOptions()}
          </select>
          <br />

          <label id="manufacturer" htmlFor="manufacturer">
            Manufacturer:
          </label>
          <input
            type="text"
            name="manufacturer"
            value={this.state.product.manufacturer}
            onChange={(evt) => this.handleChange(evt)}
          />
          <br />

          <label id="image" htmlFor="image">
            Product Image:
          </label>
          <input
            type="file"
            accept="image/png, image/jpeg"
            name="image"
            value={this.state.product.image}
            onChange={(evt) => this.handleChange(evt)}
          />
          <br />

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default AddProduct;
