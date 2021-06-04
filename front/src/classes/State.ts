import Item from './Item'
export default interface State {
  items: Array<Item>
  dialog: boolean
  confirm: boolean
  text: string
}