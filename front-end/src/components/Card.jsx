import styles from '../css/Card.module.css'
import imagem from '../assets/imgs/banner.png'
import { Agendar, Detalhes } from './Buttons.jsx'


export default function Card({ nome, descricao, preco, data }) {
    return (
        <div className={styles.card}>
            <img src={imagem} alt="" />
            <h2>{nome}</h2>
            <div className={styles.infoCard}>
                <div className={styles.info}>
                    <p>{descricao}</p>
                    <p>R$: {preco}</p>
                    <p>{data != null && !data ? `Disponivel: ${data}` : 'Sem data de tempo limite'}</p>
                </div>
                <div className={styles.buttons}>
                    <Detalhes />
                    <Agendar />
                </div>
            </div>
        </div>
    )
}