import React from 'react';
import './App.css';

import {Col, Container, Row} from "react-bootstrap";
import {BrowserRouter as Router, Switch, Route} from "react-router-dom";

import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import Footer from "./components/Footer";
import Products from "./components/Product/Products";
import NewProduct from "./components/Product/NewProduct";
import ManufacturersList from "./components/Manufacturer/ManufacturersList";
import ManufacturerAdd from "./components/Manufacturer/ManufacturerAdd";
import Play from "./components/Play";
import ProductsListForUsers from "./components/Product/ProductsListForUsers";
import ManufacturerEdit from "./components/Manufacturer/ManufacturerEdit";


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
                {/*<Route path="/products" exact component={Products}/>*/}
                <Route path="/products" exact component={ProductsListForUsers}/>
                <Route path="/add-product" exact component={NewProduct}/>
                <Route path="/manufacturers" exact component={ManufacturersList}/>
                <Route path="/add-manufacturer" exact component={ManufacturerAdd}/>
                <Route path="/play" exact component={Play}/>
                  <Route path="/edit/:id" exact component={ManufacturerEdit}/>
              </Switch>
            </Col>
          </Row>
        </Container><br/><br/>
        <Footer/>
      </Router>
  );
}

export default App;
