import React from 'react';
import ReactDOM from 'react-dom'

class Greeting extends React.Component {
  render() {
    return (
      <h1>Hello, World!</h1>
    );
  }
}

document.getElementById('app')

ReactDOM.render(<Greeting/>, app);
