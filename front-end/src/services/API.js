import axios from 'axios'
const URL_API = 'http://localhost:8080/api'

export async function getPratos() {
    const resp = await axios.get(URL_API)
    return resp.data
}