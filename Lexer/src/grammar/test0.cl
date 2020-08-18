(*This test contains normal string, string with 1024 characters with escapes, an empty srting,
	string with multiple escaped new lines*)

class Main inherits IO
{
	main() : Object
	{
		{
			-- Norml String with escaped new line, semi-colon, backslash, characters
			out_string("Hello World\nn\e\wline \"escaped semi-colon\\escaped backslash\
			This is ok");

			-- String of size 1024 with escapes
			out_string("yrchfxjtklgyojfo\euvxladbjpqciligelnlkwfujlvawaocxmaiofjxuz\bfnmntzbfjz\mflzalvdzaanakcftbbvdikrwdqzkzywglvjwtoytqlvanctrfqwoankedlocllkxittbhrwxfrzuttlbjhpmubqxmgbxtmuchofpheomxohrjusucjgykywyfzvanqevgkmpqccnslgbfayhjgivfetmfrmthrqpdegvgkizvpcdpcmbjuwqascgjqbsjrjovpjdasevjhaajnbuhakiuoodfrvqkgffvqkxkpvtwvuhixcqzoytdowkftapzhwxagukxpevlaftzhjzxjsaxrmeknvmwrlwafjzvpvipabojnpgyijybvcnkybjrmhtsqtpfoxwoanzpcfomqonmqdyqehirpdjfwanmzjazwbrbjhnzvdlnimemtodkroqoqfcpqdrngiqppfpmkczsofftksnzkdprfhikyxrgngxsxldamvoscynnt\aofffxlmfvkcospxpjucowp\klholubexpkcvhphonuqbmhaesvghrvtechszlyyaiaxrsfhfbzingjrbeyixtdeymyxxwxyhzvarciwfhftqqmrwkbtgezeqxdqwaodzldtqnpvvwqnmdeinhevlfzddetzgjeixhbnxskspbfdglovssrfxskczedfpjpmrqbojmiappfxctsunjbnelpdpvkheatxsvndjxfamlxqgpkubnhfzykqtwxawrzponsxmaxblurrlelmrutqtfhoceoyxopldkkpkhsxdkopocdfwzwpefggluhjkywpihhuqzrujilxmofindauigatcjenibcsilnalguuohuawbllenfmtihxtmmbnrwxcjxnrukibgizhvlliszdcgbwspxhgtejeewwagebmodvmqguihalodhisgqzcwiicggcpmgddjzpzhljplufodpjmhioesyiyfnprttueslfzxoqilvzqlicsssymrhmy");

			--String with multiple escaped new lines
			out_string("Multiple\
			escaped\
			newlines!!!");

			--An empty string
			out_string("");
		}
	};
};
