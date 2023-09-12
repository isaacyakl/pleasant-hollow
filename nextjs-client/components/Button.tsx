import { MouseEventHandler } from "react";

export default function ({ onClick, children, className }: { onClick?: MouseEventHandler<HTMLButtonElement>; children?: React.ReactNode; className?: string }) {
	return (
		<button className={`self-end text-center text-xs font-light border-solid border-2 border-[#c2a878] text-[#c2a878] rounded px-4 py-2 my-4 mr-4 last:mr-0 hover:bg-[#c2a878] hover:text-[#281414] ${className}`} onClick={onClick}>
			{children}
		</button>
	);
}
