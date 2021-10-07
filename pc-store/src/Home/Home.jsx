import React, { Component } from "react";
import { Route } from "react-router";
import Categories from "./Categories";
import Intro from "./Intro";
import Category from "./Category";
import Featured from "./Featured";

class Home extends Component {
  render() {
    return (
      <React.Fragment>
        <Intro />
        <div className="row">
          <div id="categories" className="col-md-3">
            <Categories />
          </div>
          <div id="page" className="col-md-9">
            <Route exact path="/Category?name=" component={Category} />
            <Route exact path="/" component={Featured} />
          </div>
        </div>
      </React.Fragment>
    );
  }
}

export default Home;
