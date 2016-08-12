import React from "react";
import ReactDOM from "react-dom";
import { Route, Router, browserHistory } from "react-router";

import Layout from "./components/Layout";
import ConversationPane from "./components/ConversationPane";

const app = document.getElementById('app');

ReactDOM.render(
  <Router history={browserHistory}>
    <Route path="/" component={Layout}>
      <Route path="/conversation/:human" component={ConversationPane}></Route>
    </Route>
  </Router>, app);
