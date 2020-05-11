import React from 'react';
import './App.css';

import {Col, Container, Row} from "react-bootstrap";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import Footer from "./components/Footer";
import Products from "./components/Products";
import NewProduct from "./components/NewProduct";
import Manufacturers from "./components/Manufacturers";
import NewManufacturer from "./components/NewManufacturer";


function App() {
  const marginTop = {
    marginTop:"20px"
  };

  return (
      <Router>
        <NavigationBar/>
        <Container>
          <Row>
            <Col lg={12} style={marginTop}>
              <Switch>
                <Route path="/" exact component={Welcome}/>
                <Route path="/products" exact component={Products}/>
                <Route path="/add-product" exact component={NewProduct}/>
                <Route path="/manufacturers" exact component={Manufacturers}/>
                <Route path="/edit/:id" exact component={NewManufacturer}/>
                <Route path="/add-manufacturer" exact component={NewManufacturer}/>
              </Switch>
            </Col>
          </Row>
        </Container>
        <Footer/>
      </Router>
  );
}

export default App;
