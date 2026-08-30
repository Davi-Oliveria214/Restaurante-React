import styles from '../css/Carrossel.module.css'
import Card from './Card.jsx'
import { getPratos } from '../services/API'
import { useEffect, useState } from 'react'

export default function Carrossel() {
    const [resp, setResp] = useState([])

    useEffect(() => {
        const request = async () => {
            const res = await getPratos()
            setResp(res.data)
        }

        request()
    }, [])

    return (
        <div className={styles.carrossel}>
            <button type='button' className={styles.btnLeft}>&lt;</button>
            <div className={styles.lista}>
                {resp.map((data) => (
                    <Card key={data.id} nome={data.nome} descricao={data.descricao} preco={data.preco} />
                ))}
            </div>
            <button type='button' className={styles.btnRight}>&gt;</button>
        </div>
    )
}