import React from "react"
import Store from "./Store.js"

export default class StorePane extends React.Component {
  renderStore(store) {
    return <Store key={store} index={store} details={this.props.stores[store]} />
  }

  render() {
    return (
      <div id="store-pane">
        <h1>Stores & Ovens</h1>
        <ul>
          {Object.keys(this.props.stores).map(this.renderStore.bind(this))}
        </ul>
      </div>
    )
  }
}
