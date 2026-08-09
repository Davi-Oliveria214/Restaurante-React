import styles from '../css/Card.module.css'
import imagem from '../assets/imgs/banner.png'
import { Agendar, Detalhes } from './Buttons.js'


export default function Card() {
    return (
        <div className={styles.card}>
            <img src={imagem} alt="" />
            <h2>Arros com feijoada</h2>
            <div className={styles.infoCard}>
                <div className={styles.info}>
                    <p>É a melhor feijoada do Brasil</p>
                    <p>Disponivél: 20/07 até 25/09</p>
                </div>
                <div className={styles.buttons}>
                    <Detalhes />
                    <Agendar />
                </div>
            </div>
        </div>
    )
}