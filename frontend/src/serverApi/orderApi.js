import axios from 'axios'
import {
    BASE_URL,
    USERS_URL,
    CATEGORY_URL,
    PRODUCT_URL,
    UPLOAD_URL,
    ORDERS_URL,
} from './constants'

export const useGetOrdersQuery = async () => {
    return await axios.get(`${BASE_URL}${ORDERS_URL}`)
}