// Generated from FSH.g4 by ANTLR 4.9.1
package science.aist.sushiya.service.languageserver.diagnostic.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FSHParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KW_ALIAS=1, KW_PROFILE=2, KW_EXTENSION=3, KW_INSTANCE=4, KW_INSTANCEOF=5, 
		KW_INVARIANT=6, KW_VALUESET=7, KW_CODESYSTEM=8, KW_RULESET=9, KW_MAPPING=10, 
		KW_MIXINS=11, KW_PARENT=12, KW_ID=13, KW_TITLE=14, KW_DESCRIPTION=15, 
		KW_EXPRESSION=16, KW_XPATH=17, KW_SEVERITY=18, KW_USAGE=19, KW_SOURCE=20, 
		KW_TARGET=21, KW_MOD=22, KW_MS=23, KW_SU=24, KW_TU=25, KW_NORMATIVE=26, 
		KW_DRAFT=27, KW_FROM=28, KW_EXAMPLE=29, KW_PREFERRED=30, KW_EXTENSIBLE=31, 
		KW_REQUIRED=32, KW_CONTAINS=33, KW_NAMED=34, KW_AND=35, KW_ONLY=36, KW_OR=37, 
		KW_OBEYS=38, KW_TRUE=39, KW_FALSE=40, KW_INCLUDE=41, KW_EXCLUDE=42, KW_CODES=43, 
		KW_WHERE=44, KW_VSREFERENCE=45, KW_SYSTEM=46, KW_UNITS=47, KW_EXACTLY=48, 
		KW_INSERT=49, EQUAL=50, STAR=51, COLON=52, COMMA=53, ARROW=54, STRING=55, 
		MULTILINE_STRING=56, NUMBER=57, UNIT=58, CODE=59, CONCEPT_STRING=60, DATETIME=61, 
		TIME=62, CARD=63, OR_REFERENCE=64, PIPE_REFERENCE=65, CANONICAL=66, CARET_SEQUENCE=67, 
		REGEX=68, COMMA_DELIMITED_CODES=69, PARAMETER_DEF_LIST=70, COMMA_DELIMITED_SEQUENCES=71, 
		BLOCK_COMMENT=72, SEQUENCE=73, WHITESPACE=74, LINE_COMMENT=75, PARAM_RULESET_REFERENCE=76, 
		RULESET_REFERENCE=77;
	public static final int
		RULE_doc = 0, RULE_entity = 1, RULE_alias = 2, RULE_profile = 3, RULE_extension = 4, 
		RULE_sdMetadata = 5, RULE_sdRule = 6, RULE_instance = 7, RULE_instanceMetadata = 8, 
		RULE_instanceRule = 9, RULE_invariant = 10, RULE_invariantMetadata = 11, 
		RULE_valueSet = 12, RULE_vsMetadata = 13, RULE_vsRule = 14, RULE_codeSystem = 15, 
		RULE_csMetadata = 16, RULE_csRule = 17, RULE_ruleSet = 18, RULE_ruleSetRule = 19, 
		RULE_paramRuleSet = 20, RULE_paramRuleSetContent = 21, RULE_mapping = 22, 
		RULE_mappingMetadata = 23, RULE_mappingEntityRule = 24, RULE_parent = 25, 
		RULE_id = 26, RULE_title = 27, RULE_description = 28, RULE_expression = 29, 
		RULE_xpath = 30, RULE_severity = 31, RULE_instanceOf = 32, RULE_usage = 33, 
		RULE_mixins = 34, RULE_source = 35, RULE_target = 36, RULE_cardRule = 37, 
		RULE_flagRule = 38, RULE_valueSetRule = 39, RULE_fixedValueRule = 40, 
		RULE_containsRule = 41, RULE_onlyRule = 42, RULE_obeysRule = 43, RULE_caretValueRule = 44, 
		RULE_mappingRule = 45, RULE_insertRule = 46, RULE_vsComponent = 47, RULE_vsConceptComponent = 48, 
		RULE_vsFilterComponent = 49, RULE_vsComponentFrom = 50, RULE_vsFromSystem = 51, 
		RULE_vsFromValueset = 52, RULE_vsFilterList = 53, RULE_vsFilterDefinition = 54, 
		RULE_vsFilterOperator = 55, RULE_vsFilterValue = 56, RULE_path = 57, RULE_paths = 58, 
		RULE_caretPath = 59, RULE_flag = 60, RULE_strength = 61, RULE_value = 62, 
		RULE_item = 63, RULE_code = 64, RULE_concept = 65, RULE_quantity = 66, 
		RULE_ratio = 67, RULE_reference = 68, RULE_canonical = 69, RULE_ratioPart = 70, 
		RULE_bool = 71, RULE_targetType = 72;
	private static String[] makeRuleNames() {
		return new String[] {
			"doc", "entity", "alias", "profile", "extension", "sdMetadata", "sdRule", 
			"instance", "instanceMetadata", "instanceRule", "invariant", "invariantMetadata", 
			"valueSet", "vsMetadata", "vsRule", "codeSystem", "csMetadata", "csRule", 
			"ruleSet", "ruleSetRule", "paramRuleSet", "paramRuleSetContent", "mapping", 
			"mappingMetadata", "mappingEntityRule", "parent", "id", "title", "description", 
			"expression", "xpath", "severity", "instanceOf", "usage", "mixins", "source", 
			"target", "cardRule", "flagRule", "valueSetRule", "fixedValueRule", "containsRule", 
			"onlyRule", "obeysRule", "caretValueRule", "mappingRule", "insertRule", 
			"vsComponent", "vsConceptComponent", "vsFilterComponent", "vsComponentFrom", 
			"vsFromSystem", "vsFromValueset", "vsFilterList", "vsFilterDefinition", 
			"vsFilterOperator", "vsFilterValue", "path", "paths", "caretPath", "flag", 
			"strength", "value", "item", "code", "concept", "quantity", "ratio", 
			"reference", "canonical", "ratioPart", "bool", "targetType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'?!'", "'MS'", 
			"'SU'", "'TU'", "'N'", "'D'", "'from'", null, null, null, null, "'contains'", 
			"'named'", "'and'", "'only'", "'or'", "'obeys'", "'true'", "'false'", 
			"'include'", "'exclude'", "'codes'", "'where'", "'valueset'", "'system'", 
			"'units'", null, "'insert'", "'='", null, "':'", "','", "'->'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KW_ALIAS", "KW_PROFILE", "KW_EXTENSION", "KW_INSTANCE", "KW_INSTANCEOF", 
			"KW_INVARIANT", "KW_VALUESET", "KW_CODESYSTEM", "KW_RULESET", "KW_MAPPING", 
			"KW_MIXINS", "KW_PARENT", "KW_ID", "KW_TITLE", "KW_DESCRIPTION", "KW_EXPRESSION", 
			"KW_XPATH", "KW_SEVERITY", "KW_USAGE", "KW_SOURCE", "KW_TARGET", "KW_MOD", 
			"KW_MS", "KW_SU", "KW_TU", "KW_NORMATIVE", "KW_DRAFT", "KW_FROM", "KW_EXAMPLE", 
			"KW_PREFERRED", "KW_EXTENSIBLE", "KW_REQUIRED", "KW_CONTAINS", "KW_NAMED", 
			"KW_AND", "KW_ONLY", "KW_OR", "KW_OBEYS", "KW_TRUE", "KW_FALSE", "KW_INCLUDE", 
			"KW_EXCLUDE", "KW_CODES", "KW_WHERE", "KW_VSREFERENCE", "KW_SYSTEM", 
			"KW_UNITS", "KW_EXACTLY", "KW_INSERT", "EQUAL", "STAR", "COLON", "COMMA", 
			"ARROW", "STRING", "MULTILINE_STRING", "NUMBER", "UNIT", "CODE", "CONCEPT_STRING", 
			"DATETIME", "TIME", "CARD", "OR_REFERENCE", "PIPE_REFERENCE", "CANONICAL", 
			"CARET_SEQUENCE", "REGEX", "COMMA_DELIMITED_CODES", "PARAMETER_DEF_LIST", 
			"COMMA_DELIMITED_SEQUENCES", "BLOCK_COMMENT", "SEQUENCE", "WHITESPACE", 
			"LINE_COMMENT", "PARAM_RULESET_REFERENCE", "RULESET_REFERENCE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FSH.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FSHParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DocContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(FSHParser.EOF, 0); }
		public List<EntityContext> entity() {
			return getRuleContexts(EntityContext.class);
		}
		public EntityContext entity(int i) {
			return getRuleContext(EntityContext.class,i);
		}
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitDoc(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_doc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ALIAS) | (1L << KW_PROFILE) | (1L << KW_EXTENSION) | (1L << KW_INSTANCE) | (1L << KW_INVARIANT) | (1L << KW_VALUESET) | (1L << KW_CODESYSTEM) | (1L << KW_RULESET) | (1L << KW_MAPPING))) != 0)) {
				{
				{
				setState(146);
				entity();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EntityContext extends ParserRuleContext {
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public ProfileContext profile() {
			return getRuleContext(ProfileContext.class,0);
		}
		public ExtensionContext extension() {
			return getRuleContext(ExtensionContext.class,0);
		}
		public InvariantContext invariant() {
			return getRuleContext(InvariantContext.class,0);
		}
		public InstanceContext instance() {
			return getRuleContext(InstanceContext.class,0);
		}
		public ValueSetContext valueSet() {
			return getRuleContext(ValueSetContext.class,0);
		}
		public CodeSystemContext codeSystem() {
			return getRuleContext(CodeSystemContext.class,0);
		}
		public RuleSetContext ruleSet() {
			return getRuleContext(RuleSetContext.class,0);
		}
		public ParamRuleSetContext paramRuleSet() {
			return getRuleContext(ParamRuleSetContext.class,0);
		}
		public MappingContext mapping() {
			return getRuleContext(MappingContext.class,0);
		}
		public EntityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterEntity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitEntity(this);
		}
	}

	public final EntityContext entity() throws RecognitionException {
		EntityContext _localctx = new EntityContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_entity);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				alias();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				profile();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				extension();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				invariant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				instance();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				valueSet();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(160);
				codeSystem();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(161);
				ruleSet();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(162);
				paramRuleSet();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(163);
				mapping();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasContext extends ParserRuleContext {
		public TerminalNode KW_ALIAS() { return getToken(FSHParser.KW_ALIAS, 0); }
		public List<TerminalNode> SEQUENCE() { return getTokens(FSHParser.SEQUENCE); }
		public TerminalNode SEQUENCE(int i) {
			return getToken(FSHParser.SEQUENCE, i);
		}
		public TerminalNode EQUAL() { return getToken(FSHParser.EQUAL, 0); }
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(KW_ALIAS);
			setState(167);
			match(SEQUENCE);
			setState(168);
			match(EQUAL);
			setState(169);
			match(SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProfileContext extends ParserRuleContext {
		public TerminalNode KW_PROFILE() { return getToken(FSHParser.KW_PROFILE, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public List<SdMetadataContext> sdMetadata() {
			return getRuleContexts(SdMetadataContext.class);
		}
		public SdMetadataContext sdMetadata(int i) {
			return getRuleContext(SdMetadataContext.class,i);
		}
		public List<SdRuleContext> sdRule() {
			return getRuleContexts(SdRuleContext.class);
		}
		public SdRuleContext sdRule(int i) {
			return getRuleContext(SdRuleContext.class,i);
		}
		public ProfileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_profile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterProfile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitProfile(this);
		}
	}

	public final ProfileContext profile() throws RecognitionException {
		ProfileContext _localctx = new ProfileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_profile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(KW_PROFILE);
			setState(172);
			match(SEQUENCE);
			setState(174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(173);
				sdMetadata();
				}
				}
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_MIXINS) | (1L << KW_PARENT) | (1L << KW_ID) | (1L << KW_TITLE) | (1L << KW_DESCRIPTION))) != 0) );
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR) {
				{
				{
				setState(178);
				sdRule();
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExtensionContext extends ParserRuleContext {
		public TerminalNode KW_EXTENSION() { return getToken(FSHParser.KW_EXTENSION, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public List<SdMetadataContext> sdMetadata() {
			return getRuleContexts(SdMetadataContext.class);
		}
		public SdMetadataContext sdMetadata(int i) {
			return getRuleContext(SdMetadataContext.class,i);
		}
		public List<SdRuleContext> sdRule() {
			return getRuleContexts(SdRuleContext.class);
		}
		public SdRuleContext sdRule(int i) {
			return getRuleContext(SdRuleContext.class,i);
		}
		public ExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitExtension(this);
		}
	}

	public final ExtensionContext extension() throws RecognitionException {
		ExtensionContext _localctx = new ExtensionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_extension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(KW_EXTENSION);
			setState(185);
			match(SEQUENCE);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_MIXINS) | (1L << KW_PARENT) | (1L << KW_ID) | (1L << KW_TITLE) | (1L << KW_DESCRIPTION))) != 0)) {
				{
				{
				setState(186);
				sdMetadata();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR) {
				{
				{
				setState(192);
				sdRule();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SdMetadataContext extends ParserRuleContext {
		public ParentContext parent() {
			return getRuleContext(ParentContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public MixinsContext mixins() {
			return getRuleContext(MixinsContext.class,0);
		}
		public SdMetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sdMetadata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterSdMetadata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitSdMetadata(this);
		}
	}

	public final SdMetadataContext sdMetadata() throws RecognitionException {
		SdMetadataContext _localctx = new SdMetadataContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sdMetadata);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_PARENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				parent();
				}
				break;
			case KW_ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				id();
				}
				break;
			case KW_TITLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				title();
				}
				break;
			case KW_DESCRIPTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				description();
				}
				break;
			case KW_MIXINS:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				mixins();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SdRuleContext extends ParserRuleContext {
		public CardRuleContext cardRule() {
			return getRuleContext(CardRuleContext.class,0);
		}
		public FlagRuleContext flagRule() {
			return getRuleContext(FlagRuleContext.class,0);
		}
		public ValueSetRuleContext valueSetRule() {
			return getRuleContext(ValueSetRuleContext.class,0);
		}
		public FixedValueRuleContext fixedValueRule() {
			return getRuleContext(FixedValueRuleContext.class,0);
		}
		public ContainsRuleContext containsRule() {
			return getRuleContext(ContainsRuleContext.class,0);
		}
		public OnlyRuleContext onlyRule() {
			return getRuleContext(OnlyRuleContext.class,0);
		}
		public ObeysRuleContext obeysRule() {
			return getRuleContext(ObeysRuleContext.class,0);
		}
		public CaretValueRuleContext caretValueRule() {
			return getRuleContext(CaretValueRuleContext.class,0);
		}
		public InsertRuleContext insertRule() {
			return getRuleContext(InsertRuleContext.class,0);
		}
		public SdRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sdRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterSdRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitSdRule(this);
		}
	}

	public final SdRuleContext sdRule() throws RecognitionException {
		SdRuleContext _localctx = new SdRuleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sdRule);
		try {
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				cardRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				flagRule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				valueSetRule();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				fixedValueRule();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				containsRule();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(210);
				onlyRule();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(211);
				obeysRule();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(212);
				caretValueRule();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(213);
				insertRule();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceContext extends ParserRuleContext {
		public TerminalNode KW_INSTANCE() { return getToken(FSHParser.KW_INSTANCE, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public List<InstanceMetadataContext> instanceMetadata() {
			return getRuleContexts(InstanceMetadataContext.class);
		}
		public InstanceMetadataContext instanceMetadata(int i) {
			return getRuleContext(InstanceMetadataContext.class,i);
		}
		public List<InstanceRuleContext> instanceRule() {
			return getRuleContexts(InstanceRuleContext.class);
		}
		public InstanceRuleContext instanceRule(int i) {
			return getRuleContext(InstanceRuleContext.class,i);
		}
		public InstanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitInstance(this);
		}
	}

	public final InstanceContext instance() throws RecognitionException {
		InstanceContext _localctx = new InstanceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instance);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(KW_INSTANCE);
			setState(217);
			match(SEQUENCE);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_INSTANCEOF) | (1L << KW_MIXINS) | (1L << KW_TITLE) | (1L << KW_DESCRIPTION) | (1L << KW_USAGE))) != 0)) {
				{
				{
				setState(218);
				instanceMetadata();
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR) {
				{
				{
				setState(224);
				instanceRule();
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceMetadataContext extends ParserRuleContext {
		public InstanceOfContext instanceOf() {
			return getRuleContext(InstanceOfContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public UsageContext usage() {
			return getRuleContext(UsageContext.class,0);
		}
		public MixinsContext mixins() {
			return getRuleContext(MixinsContext.class,0);
		}
		public InstanceMetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceMetadata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterInstanceMetadata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitInstanceMetadata(this);
		}
	}

	public final InstanceMetadataContext instanceMetadata() throws RecognitionException {
		InstanceMetadataContext _localctx = new InstanceMetadataContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instanceMetadata);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_INSTANCEOF:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				instanceOf();
				}
				break;
			case KW_TITLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				title();
				}
				break;
			case KW_DESCRIPTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				description();
				}
				break;
			case KW_USAGE:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				usage();
				}
				break;
			case KW_MIXINS:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				mixins();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceRuleContext extends ParserRuleContext {
		public FixedValueRuleContext fixedValueRule() {
			return getRuleContext(FixedValueRuleContext.class,0);
		}
		public InsertRuleContext insertRule() {
			return getRuleContext(InsertRuleContext.class,0);
		}
		public InstanceRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterInstanceRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitInstanceRule(this);
		}
	}

	public final InstanceRuleContext instanceRule() throws RecognitionException {
		InstanceRuleContext _localctx = new InstanceRuleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instanceRule);
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				fixedValueRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				insertRule();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantContext extends ParserRuleContext {
		public TerminalNode KW_INVARIANT() { return getToken(FSHParser.KW_INVARIANT, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public List<InvariantMetadataContext> invariantMetadata() {
			return getRuleContexts(InvariantMetadataContext.class);
		}
		public InvariantMetadataContext invariantMetadata(int i) {
			return getRuleContext(InvariantMetadataContext.class,i);
		}
		public InvariantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterInvariant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitInvariant(this);
		}
	}

	public final InvariantContext invariant() throws RecognitionException {
		InvariantContext _localctx = new InvariantContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_invariant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(KW_INVARIANT);
			setState(242);
			match(SEQUENCE);
			setState(244); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				invariantMetadata();
				}
				}
				setState(246); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_DESCRIPTION) | (1L << KW_EXPRESSION) | (1L << KW_XPATH) | (1L << KW_SEVERITY))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvariantMetadataContext extends ParserRuleContext {
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public XpathContext xpath() {
			return getRuleContext(XpathContext.class,0);
		}
		public SeverityContext severity() {
			return getRuleContext(SeverityContext.class,0);
		}
		public InvariantMetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariantMetadata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterInvariantMetadata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitInvariantMetadata(this);
		}
	}

	public final InvariantMetadataContext invariantMetadata() throws RecognitionException {
		InvariantMetadataContext _localctx = new InvariantMetadataContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_invariantMetadata);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_DESCRIPTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				description();
				}
				break;
			case KW_EXPRESSION:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				expression();
				}
				break;
			case KW_XPATH:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				xpath();
				}
				break;
			case KW_SEVERITY:
				enterOuterAlt(_localctx, 4);
				{
				setState(251);
				severity();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueSetContext extends ParserRuleContext {
		public TerminalNode KW_VALUESET() { return getToken(FSHParser.KW_VALUESET, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public List<VsMetadataContext> vsMetadata() {
			return getRuleContexts(VsMetadataContext.class);
		}
		public VsMetadataContext vsMetadata(int i) {
			return getRuleContext(VsMetadataContext.class,i);
		}
		public List<VsRuleContext> vsRule() {
			return getRuleContexts(VsRuleContext.class);
		}
		public VsRuleContext vsRule(int i) {
			return getRuleContext(VsRuleContext.class,i);
		}
		public ValueSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterValueSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitValueSet(this);
		}
	}

	public final ValueSetContext valueSet() throws RecognitionException {
		ValueSetContext _localctx = new ValueSetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_valueSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(KW_VALUESET);
			setState(255);
			match(SEQUENCE);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ID) | (1L << KW_TITLE) | (1L << KW_DESCRIPTION))) != 0)) {
				{
				{
				setState(256);
				vsMetadata();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR) {
				{
				{
				setState(262);
				vsRule();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsMetadataContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public VsMetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsMetadata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsMetadata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsMetadata(this);
		}
	}

	public final VsMetadataContext vsMetadata() throws RecognitionException {
		VsMetadataContext _localctx = new VsMetadataContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_vsMetadata);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				id();
				}
				break;
			case KW_TITLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				title();
				}
				break;
			case KW_DESCRIPTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(270);
				description();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsRuleContext extends ParserRuleContext {
		public VsComponentContext vsComponent() {
			return getRuleContext(VsComponentContext.class,0);
		}
		public CaretValueRuleContext caretValueRule() {
			return getRuleContext(CaretValueRuleContext.class,0);
		}
		public InsertRuleContext insertRule() {
			return getRuleContext(InsertRuleContext.class,0);
		}
		public VsRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsRule(this);
		}
	}

	public final VsRuleContext vsRule() throws RecognitionException {
		VsRuleContext _localctx = new VsRuleContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_vsRule);
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(273);
				vsComponent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				caretValueRule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(275);
				insertRule();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeSystemContext extends ParserRuleContext {
		public TerminalNode KW_CODESYSTEM() { return getToken(FSHParser.KW_CODESYSTEM, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public List<CsMetadataContext> csMetadata() {
			return getRuleContexts(CsMetadataContext.class);
		}
		public CsMetadataContext csMetadata(int i) {
			return getRuleContext(CsMetadataContext.class,i);
		}
		public List<CsRuleContext> csRule() {
			return getRuleContexts(CsRuleContext.class);
		}
		public CsRuleContext csRule(int i) {
			return getRuleContext(CsRuleContext.class,i);
		}
		public CodeSystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeSystem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCodeSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCodeSystem(this);
		}
	}

	public final CodeSystemContext codeSystem() throws RecognitionException {
		CodeSystemContext _localctx = new CodeSystemContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_codeSystem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(KW_CODESYSTEM);
			setState(279);
			match(SEQUENCE);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ID) | (1L << KW_TITLE) | (1L << KW_DESCRIPTION))) != 0)) {
				{
				{
				setState(280);
				csMetadata();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR) {
				{
				{
				setState(286);
				csRule();
				}
				}
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CsMetadataContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public CsMetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csMetadata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCsMetadata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCsMetadata(this);
		}
	}

	public final CsMetadataContext csMetadata() throws RecognitionException {
		CsMetadataContext _localctx = new CsMetadataContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_csMetadata);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				id();
				}
				break;
			case KW_TITLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				title();
				}
				break;
			case KW_DESCRIPTION:
				enterOuterAlt(_localctx, 3);
				{
				setState(294);
				description();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CsRuleContext extends ParserRuleContext {
		public ConceptContext concept() {
			return getRuleContext(ConceptContext.class,0);
		}
		public CaretValueRuleContext caretValueRule() {
			return getRuleContext(CaretValueRuleContext.class,0);
		}
		public InsertRuleContext insertRule() {
			return getRuleContext(InsertRuleContext.class,0);
		}
		public CsRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCsRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCsRule(this);
		}
	}

	public final CsRuleContext csRule() throws RecognitionException {
		CsRuleContext _localctx = new CsRuleContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_csRule);
		try {
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				concept();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				caretValueRule();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				insertRule();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleSetContext extends ParserRuleContext {
		public TerminalNode KW_RULESET() { return getToken(FSHParser.KW_RULESET, 0); }
		public TerminalNode RULESET_REFERENCE() { return getToken(FSHParser.RULESET_REFERENCE, 0); }
		public List<RuleSetRuleContext> ruleSetRule() {
			return getRuleContexts(RuleSetRuleContext.class);
		}
		public RuleSetRuleContext ruleSetRule(int i) {
			return getRuleContext(RuleSetRuleContext.class,i);
		}
		public RuleSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterRuleSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitRuleSet(this);
		}
	}

	public final RuleSetContext ruleSet() throws RecognitionException {
		RuleSetContext _localctx = new RuleSetContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ruleSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(KW_RULESET);
			setState(303);
			match(RULESET_REFERENCE);
			setState(305); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(304);
				ruleSetRule();
				}
				}
				setState(307); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STAR );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleSetRuleContext extends ParserRuleContext {
		public SdRuleContext sdRule() {
			return getRuleContext(SdRuleContext.class,0);
		}
		public ConceptContext concept() {
			return getRuleContext(ConceptContext.class,0);
		}
		public VsComponentContext vsComponent() {
			return getRuleContext(VsComponentContext.class,0);
		}
		public RuleSetRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleSetRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterRuleSetRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitRuleSetRule(this);
		}
	}

	public final RuleSetRuleContext ruleSetRule() throws RecognitionException {
		RuleSetRuleContext _localctx = new RuleSetRuleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_ruleSetRule);
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				sdRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				concept();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				vsComponent();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamRuleSetContext extends ParserRuleContext {
		public TerminalNode KW_RULESET() { return getToken(FSHParser.KW_RULESET, 0); }
		public TerminalNode PARAM_RULESET_REFERENCE() { return getToken(FSHParser.PARAM_RULESET_REFERENCE, 0); }
		public ParamRuleSetContentContext paramRuleSetContent() {
			return getRuleContext(ParamRuleSetContentContext.class,0);
		}
		public ParamRuleSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramRuleSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterParamRuleSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitParamRuleSet(this);
		}
	}

	public final ParamRuleSetContext paramRuleSet() throws RecognitionException {
		ParamRuleSetContext _localctx = new ParamRuleSetContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_paramRuleSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(KW_RULESET);
			setState(315);
			match(PARAM_RULESET_REFERENCE);
			setState(316);
			paramRuleSetContent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamRuleSetContentContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public List<TerminalNode> KW_PROFILE() { return getTokens(FSHParser.KW_PROFILE); }
		public TerminalNode KW_PROFILE(int i) {
			return getToken(FSHParser.KW_PROFILE, i);
		}
		public List<TerminalNode> KW_ALIAS() { return getTokens(FSHParser.KW_ALIAS); }
		public TerminalNode KW_ALIAS(int i) {
			return getToken(FSHParser.KW_ALIAS, i);
		}
		public List<TerminalNode> KW_EXTENSION() { return getTokens(FSHParser.KW_EXTENSION); }
		public TerminalNode KW_EXTENSION(int i) {
			return getToken(FSHParser.KW_EXTENSION, i);
		}
		public List<TerminalNode> KW_INSTANCE() { return getTokens(FSHParser.KW_INSTANCE); }
		public TerminalNode KW_INSTANCE(int i) {
			return getToken(FSHParser.KW_INSTANCE, i);
		}
		public List<TerminalNode> KW_INVARIANT() { return getTokens(FSHParser.KW_INVARIANT); }
		public TerminalNode KW_INVARIANT(int i) {
			return getToken(FSHParser.KW_INVARIANT, i);
		}
		public List<TerminalNode> KW_VALUESET() { return getTokens(FSHParser.KW_VALUESET); }
		public TerminalNode KW_VALUESET(int i) {
			return getToken(FSHParser.KW_VALUESET, i);
		}
		public List<TerminalNode> KW_CODESYSTEM() { return getTokens(FSHParser.KW_CODESYSTEM); }
		public TerminalNode KW_CODESYSTEM(int i) {
			return getToken(FSHParser.KW_CODESYSTEM, i);
		}
		public List<TerminalNode> KW_RULESET() { return getTokens(FSHParser.KW_RULESET); }
		public TerminalNode KW_RULESET(int i) {
			return getToken(FSHParser.KW_RULESET, i);
		}
		public List<TerminalNode> KW_MAPPING() { return getTokens(FSHParser.KW_MAPPING); }
		public TerminalNode KW_MAPPING(int i) {
			return getToken(FSHParser.KW_MAPPING, i);
		}
		public ParamRuleSetContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramRuleSetContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterParamRuleSetContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitParamRuleSetContent(this);
		}
	}

	public final ParamRuleSetContentContext paramRuleSetContent() throws RecognitionException {
		ParamRuleSetContentContext _localctx = new ParamRuleSetContentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_paramRuleSetContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(STAR);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_INSTANCEOF) | (1L << KW_MIXINS) | (1L << KW_PARENT) | (1L << KW_ID) | (1L << KW_TITLE) | (1L << KW_DESCRIPTION) | (1L << KW_EXPRESSION) | (1L << KW_XPATH) | (1L << KW_SEVERITY) | (1L << KW_USAGE) | (1L << KW_SOURCE) | (1L << KW_TARGET) | (1L << KW_MOD) | (1L << KW_MS) | (1L << KW_SU) | (1L << KW_TU) | (1L << KW_NORMATIVE) | (1L << KW_DRAFT) | (1L << KW_FROM) | (1L << KW_EXAMPLE) | (1L << KW_PREFERRED) | (1L << KW_EXTENSIBLE) | (1L << KW_REQUIRED) | (1L << KW_CONTAINS) | (1L << KW_NAMED) | (1L << KW_AND) | (1L << KW_ONLY) | (1L << KW_OR) | (1L << KW_OBEYS) | (1L << KW_TRUE) | (1L << KW_FALSE) | (1L << KW_INCLUDE) | (1L << KW_EXCLUDE) | (1L << KW_CODES) | (1L << KW_WHERE) | (1L << KW_VSREFERENCE) | (1L << KW_SYSTEM) | (1L << KW_UNITS) | (1L << KW_EXACTLY) | (1L << KW_INSERT) | (1L << EQUAL) | (1L << STAR) | (1L << COLON) | (1L << COMMA) | (1L << ARROW) | (1L << STRING) | (1L << MULTILINE_STRING) | (1L << NUMBER) | (1L << UNIT) | (1L << CODE) | (1L << CONCEPT_STRING) | (1L << DATETIME) | (1L << TIME) | (1L << CARD))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (OR_REFERENCE - 64)) | (1L << (PIPE_REFERENCE - 64)) | (1L << (CANONICAL - 64)) | (1L << (CARET_SEQUENCE - 64)) | (1L << (REGEX - 64)) | (1L << (COMMA_DELIMITED_CODES - 64)) | (1L << (PARAMETER_DEF_LIST - 64)) | (1L << (COMMA_DELIMITED_SEQUENCES - 64)) | (1L << (BLOCK_COMMENT - 64)) | (1L << (SEQUENCE - 64)) | (1L << (WHITESPACE - 64)) | (1L << (LINE_COMMENT - 64)) | (1L << (PARAM_RULESET_REFERENCE - 64)) | (1L << (RULESET_REFERENCE - 64)))) != 0)) {
				{
				{
				setState(319);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ALIAS) | (1L << KW_PROFILE) | (1L << KW_EXTENSION) | (1L << KW_INSTANCE) | (1L << KW_INVARIANT) | (1L << KW_VALUESET) | (1L << KW_CODESYSTEM) | (1L << KW_RULESET) | (1L << KW_MAPPING))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MappingContext extends ParserRuleContext {
		public TerminalNode KW_MAPPING() { return getToken(FSHParser.KW_MAPPING, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public List<MappingMetadataContext> mappingMetadata() {
			return getRuleContexts(MappingMetadataContext.class);
		}
		public MappingMetadataContext mappingMetadata(int i) {
			return getRuleContext(MappingMetadataContext.class,i);
		}
		public List<MappingEntityRuleContext> mappingEntityRule() {
			return getRuleContexts(MappingEntityRuleContext.class);
		}
		public MappingEntityRuleContext mappingEntityRule(int i) {
			return getRuleContext(MappingEntityRuleContext.class,i);
		}
		public MappingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterMapping(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitMapping(this);
		}
	}

	public final MappingContext mapping() throws RecognitionException {
		MappingContext _localctx = new MappingContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mapping);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(KW_MAPPING);
			setState(326);
			match(SEQUENCE);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_ID) | (1L << KW_TITLE) | (1L << KW_DESCRIPTION) | (1L << KW_SOURCE) | (1L << KW_TARGET))) != 0)) {
				{
				{
				setState(327);
				mappingMetadata();
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STAR) {
				{
				{
				setState(333);
				mappingEntityRule();
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MappingMetadataContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public TargetContext target() {
			return getRuleContext(TargetContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public MappingMetadataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingMetadata; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterMappingMetadata(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitMappingMetadata(this);
		}
	}

	public final MappingMetadataContext mappingMetadata() throws RecognitionException {
		MappingMetadataContext _localctx = new MappingMetadataContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mappingMetadata);
		try {
			setState(344);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				id();
				}
				break;
			case KW_SOURCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				source();
				}
				break;
			case KW_TARGET:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				target();
				}
				break;
			case KW_DESCRIPTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(342);
				description();
				}
				break;
			case KW_TITLE:
				enterOuterAlt(_localctx, 5);
				{
				setState(343);
				title();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MappingEntityRuleContext extends ParserRuleContext {
		public MappingRuleContext mappingRule() {
			return getRuleContext(MappingRuleContext.class,0);
		}
		public InsertRuleContext insertRule() {
			return getRuleContext(InsertRuleContext.class,0);
		}
		public MappingEntityRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingEntityRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterMappingEntityRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitMappingEntityRule(this);
		}
	}

	public final MappingEntityRuleContext mappingEntityRule() throws RecognitionException {
		MappingEntityRuleContext _localctx = new MappingEntityRuleContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mappingEntityRule);
		try {
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				mappingRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				insertRule();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParentContext extends ParserRuleContext {
		public TerminalNode KW_PARENT() { return getToken(FSHParser.KW_PARENT, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public ParentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitParent(this);
		}
	}

	public final ParentContext parent() throws RecognitionException {
		ParentContext _localctx = new ParentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(KW_PARENT);
			setState(351);
			match(SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode KW_ID() { return getToken(FSHParser.KW_ID, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(KW_ID);
			setState(354);
			match(SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TitleContext extends ParserRuleContext {
		public TerminalNode KW_TITLE() { return getToken(FSHParser.KW_TITLE, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(KW_TITLE);
			setState(357);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode KW_DESCRIPTION() { return getToken(FSHParser.KW_DESCRIPTION, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public TerminalNode MULTILINE_STRING() { return getToken(FSHParser.MULTILINE_STRING, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(KW_DESCRIPTION);
			setState(360);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==MULTILINE_STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode KW_EXPRESSION() { return getToken(FSHParser.KW_EXPRESSION, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(KW_EXPRESSION);
			setState(363);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XpathContext extends ParserRuleContext {
		public TerminalNode KW_XPATH() { return getToken(FSHParser.KW_XPATH, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public XpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xpath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterXpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitXpath(this);
		}
	}

	public final XpathContext xpath() throws RecognitionException {
		XpathContext _localctx = new XpathContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_xpath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(KW_XPATH);
			setState(366);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SeverityContext extends ParserRuleContext {
		public TerminalNode KW_SEVERITY() { return getToken(FSHParser.KW_SEVERITY, 0); }
		public TerminalNode CODE() { return getToken(FSHParser.CODE, 0); }
		public SeverityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_severity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterSeverity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitSeverity(this);
		}
	}

	public final SeverityContext severity() throws RecognitionException {
		SeverityContext _localctx = new SeverityContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_severity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(KW_SEVERITY);
			setState(369);
			match(CODE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceOfContext extends ParserRuleContext {
		public TerminalNode KW_INSTANCEOF() { return getToken(FSHParser.KW_INSTANCEOF, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public InstanceOfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceOf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterInstanceOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitInstanceOf(this);
		}
	}

	public final InstanceOfContext instanceOf() throws RecognitionException {
		InstanceOfContext _localctx = new InstanceOfContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_instanceOf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(KW_INSTANCEOF);
			setState(372);
			match(SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UsageContext extends ParserRuleContext {
		public TerminalNode KW_USAGE() { return getToken(FSHParser.KW_USAGE, 0); }
		public TerminalNode CODE() { return getToken(FSHParser.CODE, 0); }
		public UsageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_usage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterUsage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitUsage(this);
		}
	}

	public final UsageContext usage() throws RecognitionException {
		UsageContext _localctx = new UsageContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_usage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(KW_USAGE);
			setState(375);
			match(CODE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MixinsContext extends ParserRuleContext {
		public TerminalNode KW_MIXINS() { return getToken(FSHParser.KW_MIXINS, 0); }
		public List<TerminalNode> SEQUENCE() { return getTokens(FSHParser.SEQUENCE); }
		public TerminalNode SEQUENCE(int i) {
			return getToken(FSHParser.SEQUENCE, i);
		}
		public TerminalNode COMMA_DELIMITED_SEQUENCES() { return getToken(FSHParser.COMMA_DELIMITED_SEQUENCES, 0); }
		public List<TerminalNode> KW_AND() { return getTokens(FSHParser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(FSHParser.KW_AND, i);
		}
		public MixinsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mixins; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterMixins(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitMixins(this);
		}
	}

	public final MixinsContext mixins() throws RecognitionException {
		MixinsContext _localctx = new MixinsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mixins);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(KW_MIXINS);
			setState(387);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEQUENCE:
				{
				setState(382);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(378);
						match(SEQUENCE);
						setState(379);
						match(KW_AND);
						}
						} 
					}
					setState(384);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(385);
				match(SEQUENCE);
				}
				break;
			case COMMA_DELIMITED_SEQUENCES:
				{
				setState(386);
				match(COMMA_DELIMITED_SEQUENCES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceContext extends ParserRuleContext {
		public TerminalNode KW_SOURCE() { return getToken(FSHParser.KW_SOURCE, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(KW_SOURCE);
			setState(390);
			match(SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetContext extends ParserRuleContext {
		public TerminalNode KW_TARGET() { return getToken(FSHParser.KW_TARGET, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public TargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterTarget(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitTarget(this);
		}
	}

	public final TargetContext target() throws RecognitionException {
		TargetContext _localctx = new TargetContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(KW_TARGET);
			setState(393);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CardRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode CARD() { return getToken(FSHParser.CARD, 0); }
		public List<FlagContext> flag() {
			return getRuleContexts(FlagContext.class);
		}
		public FlagContext flag(int i) {
			return getRuleContext(FlagContext.class,i);
		}
		public CardRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCardRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCardRule(this);
		}
	}

	public final CardRuleContext cardRule() throws RecognitionException {
		CardRuleContext _localctx = new CardRuleContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_cardRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(STAR);
			setState(396);
			path();
			setState(397);
			match(CARD);
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_MOD) | (1L << KW_MS) | (1L << KW_SU) | (1L << KW_TU) | (1L << KW_NORMATIVE) | (1L << KW_DRAFT))) != 0)) {
				{
				{
				setState(398);
				flag();
				}
				}
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlagRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public List<PathContext> path() {
			return getRuleContexts(PathContext.class);
		}
		public PathContext path(int i) {
			return getRuleContext(PathContext.class,i);
		}
		public PathsContext paths() {
			return getRuleContext(PathsContext.class,0);
		}
		public List<FlagContext> flag() {
			return getRuleContexts(FlagContext.class);
		}
		public FlagContext flag(int i) {
			return getRuleContext(FlagContext.class,i);
		}
		public List<TerminalNode> KW_AND() { return getTokens(FSHParser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(FSHParser.KW_AND, i);
		}
		public FlagRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flagRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterFlagRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitFlagRule(this);
		}
	}

	public final FlagRuleContext flagRule() throws RecognitionException {
		FlagRuleContext _localctx = new FlagRuleContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_flagRule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(STAR);
			setState(415);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SYSTEM:
			case SEQUENCE:
				{
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(405);
						path();
						setState(406);
						match(KW_AND);
						}
						} 
					}
					setState(412);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				setState(413);
				path();
				}
				break;
			case COMMA_DELIMITED_SEQUENCES:
				{
				setState(414);
				paths();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(418); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(417);
				flag();
				}
				}
				setState(420); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_MOD) | (1L << KW_MS) | (1L << KW_SU) | (1L << KW_TU) | (1L << KW_NORMATIVE) | (1L << KW_DRAFT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueSetRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode KW_FROM() { return getToken(FSHParser.KW_FROM, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public TerminalNode KW_UNITS() { return getToken(FSHParser.KW_UNITS, 0); }
		public StrengthContext strength() {
			return getRuleContext(StrengthContext.class,0);
		}
		public ValueSetRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueSetRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterValueSetRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitValueSetRule(this);
		}
	}

	public final ValueSetRuleContext valueSetRule() throws RecognitionException {
		ValueSetRuleContext _localctx = new ValueSetRuleContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_valueSetRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			match(STAR);
			setState(423);
			path();
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_UNITS) {
				{
				setState(424);
				match(KW_UNITS);
				}
			}

			setState(427);
			match(KW_FROM);
			setState(428);
			match(SEQUENCE);
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_EXAMPLE) | (1L << KW_PREFERRED) | (1L << KW_EXTENSIBLE) | (1L << KW_REQUIRED))) != 0)) {
				{
				setState(429);
				strength();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FixedValueRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(FSHParser.EQUAL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode KW_UNITS() { return getToken(FSHParser.KW_UNITS, 0); }
		public TerminalNode KW_EXACTLY() { return getToken(FSHParser.KW_EXACTLY, 0); }
		public FixedValueRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixedValueRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterFixedValueRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitFixedValueRule(this);
		}
	}

	public final FixedValueRuleContext fixedValueRule() throws RecognitionException {
		FixedValueRuleContext _localctx = new FixedValueRuleContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_fixedValueRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			match(STAR);
			setState(433);
			path();
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_UNITS) {
				{
				setState(434);
				match(KW_UNITS);
				}
			}

			setState(437);
			match(EQUAL);
			setState(438);
			value();
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_EXACTLY) {
				{
				setState(439);
				match(KW_EXACTLY);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContainsRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode KW_CONTAINS() { return getToken(FSHParser.KW_CONTAINS, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<TerminalNode> KW_AND() { return getTokens(FSHParser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(FSHParser.KW_AND, i);
		}
		public ContainsRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_containsRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterContainsRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitContainsRule(this);
		}
	}

	public final ContainsRuleContext containsRule() throws RecognitionException {
		ContainsRuleContext _localctx = new ContainsRuleContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_containsRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			match(STAR);
			setState(443);
			path();
			setState(444);
			match(KW_CONTAINS);
			setState(445);
			item();
			setState(450);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_AND) {
				{
				{
				setState(446);
				match(KW_AND);
				setState(447);
				item();
				}
				}
				setState(452);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OnlyRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode KW_ONLY() { return getToken(FSHParser.KW_ONLY, 0); }
		public List<TargetTypeContext> targetType() {
			return getRuleContexts(TargetTypeContext.class);
		}
		public TargetTypeContext targetType(int i) {
			return getRuleContext(TargetTypeContext.class,i);
		}
		public List<TerminalNode> KW_OR() { return getTokens(FSHParser.KW_OR); }
		public TerminalNode KW_OR(int i) {
			return getToken(FSHParser.KW_OR, i);
		}
		public OnlyRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onlyRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterOnlyRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitOnlyRule(this);
		}
	}

	public final OnlyRuleContext onlyRule() throws RecognitionException {
		OnlyRuleContext _localctx = new OnlyRuleContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_onlyRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(STAR);
			setState(454);
			path();
			setState(455);
			match(KW_ONLY);
			setState(456);
			targetType();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_OR) {
				{
				{
				setState(457);
				match(KW_OR);
				setState(458);
				targetType();
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObeysRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public TerminalNode KW_OBEYS() { return getToken(FSHParser.KW_OBEYS, 0); }
		public List<TerminalNode> SEQUENCE() { return getTokens(FSHParser.SEQUENCE); }
		public TerminalNode SEQUENCE(int i) {
			return getToken(FSHParser.SEQUENCE, i);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public List<TerminalNode> KW_AND() { return getTokens(FSHParser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(FSHParser.KW_AND, i);
		}
		public ObeysRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obeysRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterObeysRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitObeysRule(this);
		}
	}

	public final ObeysRuleContext obeysRule() throws RecognitionException {
		ObeysRuleContext _localctx = new ObeysRuleContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_obeysRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(STAR);
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_SYSTEM || _la==SEQUENCE) {
				{
				setState(465);
				path();
				}
			}

			setState(468);
			match(KW_OBEYS);
			setState(469);
			match(SEQUENCE);
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_AND) {
				{
				{
				setState(470);
				match(KW_AND);
				setState(471);
				match(SEQUENCE);
				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaretValueRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public CaretPathContext caretPath() {
			return getRuleContext(CaretPathContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(FSHParser.EQUAL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public CaretValueRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caretValueRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCaretValueRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCaretValueRule(this);
		}
	}

	public final CaretValueRuleContext caretValueRule() throws RecognitionException {
		CaretValueRuleContext _localctx = new CaretValueRuleContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_caretValueRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(STAR);
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_SYSTEM || _la==SEQUENCE) {
				{
				setState(478);
				path();
				}
			}

			setState(481);
			caretPath();
			setState(482);
			match(EQUAL);
			setState(483);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MappingRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public TerminalNode ARROW() { return getToken(FSHParser.ARROW, 0); }
		public List<TerminalNode> STRING() { return getTokens(FSHParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FSHParser.STRING, i);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode CODE() { return getToken(FSHParser.CODE, 0); }
		public MappingRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mappingRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterMappingRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitMappingRule(this);
		}
	}

	public final MappingRuleContext mappingRule() throws RecognitionException {
		MappingRuleContext _localctx = new MappingRuleContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_mappingRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			match(STAR);
			setState(487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_SYSTEM || _la==SEQUENCE) {
				{
				setState(486);
				path();
				}
			}

			setState(489);
			match(ARROW);
			setState(490);
			match(STRING);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(491);
				match(STRING);
				}
			}

			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(494);
				match(CODE);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertRuleContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public TerminalNode KW_INSERT() { return getToken(FSHParser.KW_INSERT, 0); }
		public TerminalNode RULESET_REFERENCE() { return getToken(FSHParser.RULESET_REFERENCE, 0); }
		public TerminalNode PARAM_RULESET_REFERENCE() { return getToken(FSHParser.PARAM_RULESET_REFERENCE, 0); }
		public InsertRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterInsertRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitInsertRule(this);
		}
	}

	public final InsertRuleContext insertRule() throws RecognitionException {
		InsertRuleContext _localctx = new InsertRuleContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_insertRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(STAR);
			setState(498);
			match(KW_INSERT);
			setState(499);
			_la = _input.LA(1);
			if ( !(_la==PARAM_RULESET_REFERENCE || _la==RULESET_REFERENCE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsComponentContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public VsConceptComponentContext vsConceptComponent() {
			return getRuleContext(VsConceptComponentContext.class,0);
		}
		public VsFilterComponentContext vsFilterComponent() {
			return getRuleContext(VsFilterComponentContext.class,0);
		}
		public TerminalNode KW_INCLUDE() { return getToken(FSHParser.KW_INCLUDE, 0); }
		public TerminalNode KW_EXCLUDE() { return getToken(FSHParser.KW_EXCLUDE, 0); }
		public VsComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsComponent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsComponent(this);
		}
	}

	public final VsComponentContext vsComponent() throws RecognitionException {
		VsComponentContext _localctx = new VsComponentContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_vsComponent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(STAR);
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_INCLUDE || _la==KW_EXCLUDE) {
				{
				setState(502);
				_la = _input.LA(1);
				if ( !(_la==KW_INCLUDE || _la==KW_EXCLUDE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(507);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CODE:
			case COMMA_DELIMITED_CODES:
				{
				setState(505);
				vsConceptComponent();
				}
				break;
			case KW_CODES:
				{
				setState(506);
				vsFilterComponent();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsConceptComponentContext extends ParserRuleContext {
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public VsComponentFromContext vsComponentFrom() {
			return getRuleContext(VsComponentFromContext.class,0);
		}
		public List<TerminalNode> KW_AND() { return getTokens(FSHParser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(FSHParser.KW_AND, i);
		}
		public TerminalNode COMMA_DELIMITED_CODES() { return getToken(FSHParser.COMMA_DELIMITED_CODES, 0); }
		public VsConceptComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsConceptComponent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsConceptComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsConceptComponent(this);
		}
	}

	public final VsConceptComponentContext vsConceptComponent() throws RecognitionException {
		VsConceptComponentContext _localctx = new VsConceptComponentContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_vsConceptComponent);
		int _la;
		try {
			int _alt;
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(509);
				code();
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_FROM) {
					{
					setState(510);
					vsComponentFrom();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(516); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(513);
						code();
						setState(514);
						match(KW_AND);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(518); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(520);
				code();
				setState(521);
				vsComponentFrom();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				match(COMMA_DELIMITED_CODES);
				setState(524);
				vsComponentFrom();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsFilterComponentContext extends ParserRuleContext {
		public TerminalNode KW_CODES() { return getToken(FSHParser.KW_CODES, 0); }
		public VsComponentFromContext vsComponentFrom() {
			return getRuleContext(VsComponentFromContext.class,0);
		}
		public TerminalNode KW_WHERE() { return getToken(FSHParser.KW_WHERE, 0); }
		public VsFilterListContext vsFilterList() {
			return getRuleContext(VsFilterListContext.class,0);
		}
		public VsFilterComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsFilterComponent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsFilterComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsFilterComponent(this);
		}
	}

	public final VsFilterComponentContext vsFilterComponent() throws RecognitionException {
		VsFilterComponentContext _localctx = new VsFilterComponentContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_vsFilterComponent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(KW_CODES);
			setState(528);
			vsComponentFrom();
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_WHERE) {
				{
				setState(529);
				match(KW_WHERE);
				setState(530);
				vsFilterList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsComponentFromContext extends ParserRuleContext {
		public TerminalNode KW_FROM() { return getToken(FSHParser.KW_FROM, 0); }
		public VsFromSystemContext vsFromSystem() {
			return getRuleContext(VsFromSystemContext.class,0);
		}
		public VsFromValuesetContext vsFromValueset() {
			return getRuleContext(VsFromValuesetContext.class,0);
		}
		public TerminalNode KW_AND() { return getToken(FSHParser.KW_AND, 0); }
		public VsComponentFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsComponentFrom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsComponentFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsComponentFrom(this);
		}
	}

	public final VsComponentFromContext vsComponentFrom() throws RecognitionException {
		VsComponentFromContext _localctx = new VsComponentFromContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_vsComponentFrom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			match(KW_FROM);
			setState(544);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_SYSTEM:
				{
				setState(534);
				vsFromSystem();
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_AND) {
					{
					setState(535);
					match(KW_AND);
					setState(536);
					vsFromValueset();
					}
				}

				}
				break;
			case KW_VSREFERENCE:
				{
				setState(539);
				vsFromValueset();
				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_AND) {
					{
					setState(540);
					match(KW_AND);
					setState(541);
					vsFromSystem();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsFromSystemContext extends ParserRuleContext {
		public TerminalNode KW_SYSTEM() { return getToken(FSHParser.KW_SYSTEM, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public VsFromSystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsFromSystem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsFromSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsFromSystem(this);
		}
	}

	public final VsFromSystemContext vsFromSystem() throws RecognitionException {
		VsFromSystemContext _localctx = new VsFromSystemContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_vsFromSystem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(KW_SYSTEM);
			setState(547);
			match(SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsFromValuesetContext extends ParserRuleContext {
		public TerminalNode KW_VSREFERENCE() { return getToken(FSHParser.KW_VSREFERENCE, 0); }
		public List<TerminalNode> SEQUENCE() { return getTokens(FSHParser.SEQUENCE); }
		public TerminalNode SEQUENCE(int i) {
			return getToken(FSHParser.SEQUENCE, i);
		}
		public TerminalNode COMMA_DELIMITED_SEQUENCES() { return getToken(FSHParser.COMMA_DELIMITED_SEQUENCES, 0); }
		public List<TerminalNode> KW_AND() { return getTokens(FSHParser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(FSHParser.KW_AND, i);
		}
		public VsFromValuesetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsFromValueset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsFromValueset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsFromValueset(this);
		}
	}

	public final VsFromValuesetContext vsFromValueset() throws RecognitionException {
		VsFromValuesetContext _localctx = new VsFromValuesetContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_vsFromValueset);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			match(KW_VSREFERENCE);
			setState(559);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEQUENCE:
				{
				setState(554);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(550);
						match(SEQUENCE);
						setState(551);
						match(KW_AND);
						}
						} 
					}
					setState(556);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
				}
				setState(557);
				match(SEQUENCE);
				}
				break;
			case COMMA_DELIMITED_SEQUENCES:
				{
				setState(558);
				match(COMMA_DELIMITED_SEQUENCES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsFilterListContext extends ParserRuleContext {
		public List<VsFilterDefinitionContext> vsFilterDefinition() {
			return getRuleContexts(VsFilterDefinitionContext.class);
		}
		public VsFilterDefinitionContext vsFilterDefinition(int i) {
			return getRuleContext(VsFilterDefinitionContext.class,i);
		}
		public List<TerminalNode> KW_AND() { return getTokens(FSHParser.KW_AND); }
		public TerminalNode KW_AND(int i) {
			return getToken(FSHParser.KW_AND, i);
		}
		public VsFilterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsFilterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsFilterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsFilterList(this);
		}
	}

	public final VsFilterListContext vsFilterList() throws RecognitionException {
		VsFilterListContext _localctx = new VsFilterListContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_vsFilterList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(561);
					vsFilterDefinition();
					setState(562);
					match(KW_AND);
					}
					} 
				}
				setState(568);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			setState(569);
			vsFilterDefinition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsFilterDefinitionContext extends ParserRuleContext {
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public VsFilterOperatorContext vsFilterOperator() {
			return getRuleContext(VsFilterOperatorContext.class,0);
		}
		public VsFilterValueContext vsFilterValue() {
			return getRuleContext(VsFilterValueContext.class,0);
		}
		public VsFilterDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsFilterDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsFilterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsFilterDefinition(this);
		}
	}

	public final VsFilterDefinitionContext vsFilterDefinition() throws RecognitionException {
		VsFilterDefinitionContext _localctx = new VsFilterDefinitionContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_vsFilterDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(SEQUENCE);
			setState(572);
			vsFilterOperator();
			setState(574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (KW_TRUE - 39)) | (1L << (KW_FALSE - 39)) | (1L << (STRING - 39)) | (1L << (CODE - 39)) | (1L << (REGEX - 39)))) != 0)) {
				{
				setState(573);
				vsFilterValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsFilterOperatorContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(FSHParser.EQUAL, 0); }
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public VsFilterOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsFilterOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsFilterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsFilterOperator(this);
		}
	}

	public final VsFilterOperatorContext vsFilterOperator() throws RecognitionException {
		VsFilterOperatorContext _localctx = new VsFilterOperatorContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_vsFilterOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			_la = _input.LA(1);
			if ( !(_la==EQUAL || _la==SEQUENCE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VsFilterValueContext extends ParserRuleContext {
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode KW_TRUE() { return getToken(FSHParser.KW_TRUE, 0); }
		public TerminalNode KW_FALSE() { return getToken(FSHParser.KW_FALSE, 0); }
		public TerminalNode REGEX() { return getToken(FSHParser.REGEX, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public VsFilterValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vsFilterValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterVsFilterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitVsFilterValue(this);
		}
	}

	public final VsFilterValueContext vsFilterValue() throws RecognitionException {
		VsFilterValueContext _localctx = new VsFilterValueContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_vsFilterValue);
		try {
			setState(583);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CODE:
				enterOuterAlt(_localctx, 1);
				{
				setState(578);
				code();
				}
				break;
			case KW_TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				match(KW_TRUE);
				}
				break;
			case KW_FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(580);
				match(KW_FALSE);
				}
				break;
			case REGEX:
				enterOuterAlt(_localctx, 4);
				{
				setState(581);
				match(REGEX);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(582);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public TerminalNode KW_SYSTEM() { return getToken(FSHParser.KW_SYSTEM, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			_la = _input.LA(1);
			if ( !(_la==KW_SYSTEM || _la==SEQUENCE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathsContext extends ParserRuleContext {
		public TerminalNode COMMA_DELIMITED_SEQUENCES() { return getToken(FSHParser.COMMA_DELIMITED_SEQUENCES, 0); }
		public PathsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paths; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterPaths(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitPaths(this);
		}
	}

	public final PathsContext paths() throws RecognitionException {
		PathsContext _localctx = new PathsContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_paths);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			match(COMMA_DELIMITED_SEQUENCES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaretPathContext extends ParserRuleContext {
		public TerminalNode CARET_SEQUENCE() { return getToken(FSHParser.CARET_SEQUENCE, 0); }
		public CaretPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caretPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCaretPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCaretPath(this);
		}
	}

	public final CaretPathContext caretPath() throws RecognitionException {
		CaretPathContext _localctx = new CaretPathContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_caretPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(CARET_SEQUENCE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlagContext extends ParserRuleContext {
		public TerminalNode KW_MOD() { return getToken(FSHParser.KW_MOD, 0); }
		public TerminalNode KW_MS() { return getToken(FSHParser.KW_MS, 0); }
		public TerminalNode KW_SU() { return getToken(FSHParser.KW_SU, 0); }
		public TerminalNode KW_TU() { return getToken(FSHParser.KW_TU, 0); }
		public TerminalNode KW_NORMATIVE() { return getToken(FSHParser.KW_NORMATIVE, 0); }
		public TerminalNode KW_DRAFT() { return getToken(FSHParser.KW_DRAFT, 0); }
		public FlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterFlag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitFlag(this);
		}
	}

	public final FlagContext flag() throws RecognitionException {
		FlagContext _localctx = new FlagContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_flag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_MOD) | (1L << KW_MS) | (1L << KW_SU) | (1L << KW_TU) | (1L << KW_NORMATIVE) | (1L << KW_DRAFT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrengthContext extends ParserRuleContext {
		public TerminalNode KW_EXAMPLE() { return getToken(FSHParser.KW_EXAMPLE, 0); }
		public TerminalNode KW_PREFERRED() { return getToken(FSHParser.KW_PREFERRED, 0); }
		public TerminalNode KW_EXTENSIBLE() { return getToken(FSHParser.KW_EXTENSIBLE, 0); }
		public TerminalNode KW_REQUIRED() { return getToken(FSHParser.KW_REQUIRED, 0); }
		public StrengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strength; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterStrength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitStrength(this);
		}
	}

	public final StrengthContext strength() throws RecognitionException {
		StrengthContext _localctx = new StrengthContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_strength);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_EXAMPLE) | (1L << KW_PREFERRED) | (1L << KW_EXTENSIBLE) | (1L << KW_REQUIRED))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public TerminalNode MULTILINE_STRING() { return getToken(FSHParser.MULTILINE_STRING, 0); }
		public TerminalNode NUMBER() { return getToken(FSHParser.NUMBER, 0); }
		public TerminalNode DATETIME() { return getToken(FSHParser.DATETIME, 0); }
		public TerminalNode TIME() { return getToken(FSHParser.TIME, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public CanonicalContext canonical() {
			return getRuleContext(CanonicalContext.class,0);
		}
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public QuantityContext quantity() {
			return getRuleContext(QuantityContext.class,0);
		}
		public RatioContext ratio() {
			return getRuleContext(RatioContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_value);
		try {
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(595);
				match(SEQUENCE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(596);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(597);
				match(MULTILINE_STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(598);
				match(NUMBER);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(599);
				match(DATETIME);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(600);
				match(TIME);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(601);
				reference();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(602);
				canonical();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(603);
				code();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(604);
				quantity();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(605);
				ratio();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(606);
				bool();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public List<TerminalNode> SEQUENCE() { return getTokens(FSHParser.SEQUENCE); }
		public TerminalNode SEQUENCE(int i) {
			return getToken(FSHParser.SEQUENCE, i);
		}
		public TerminalNode CARD() { return getToken(FSHParser.CARD, 0); }
		public TerminalNode KW_NAMED() { return getToken(FSHParser.KW_NAMED, 0); }
		public List<FlagContext> flag() {
			return getRuleContexts(FlagContext.class);
		}
		public FlagContext flag(int i) {
			return getRuleContext(FlagContext.class,i);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitItem(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			match(SEQUENCE);
			setState(612);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_NAMED) {
				{
				setState(610);
				match(KW_NAMED);
				setState(611);
				match(SEQUENCE);
				}
			}

			setState(614);
			match(CARD);
			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_MOD) | (1L << KW_MS) | (1L << KW_SU) | (1L << KW_TU) | (1L << KW_NORMATIVE) | (1L << KW_DRAFT))) != 0)) {
				{
				{
				setState(615);
				flag();
				}
				}
				setState(620);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode CODE() { return getToken(FSHParser.CODE, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(CODE);
			setState(623);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(622);
				match(STRING);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConceptContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(FSHParser.STAR, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public TerminalNode MULTILINE_STRING() { return getToken(FSHParser.MULTILINE_STRING, 0); }
		public ConceptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concept; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterConcept(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitConcept(this);
		}
	}

	public final ConceptContext concept() throws RecognitionException {
		ConceptContext _localctx = new ConceptContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_concept);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			match(STAR);
			setState(626);
			code();
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING || _la==MULTILINE_STRING) {
				{
				setState(627);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==MULTILINE_STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantityContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(FSHParser.NUMBER, 0); }
		public TerminalNode UNIT() { return getToken(FSHParser.UNIT, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public QuantityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterQuantity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitQuantity(this);
		}
	}

	public final QuantityContext quantity() throws RecognitionException {
		QuantityContext _localctx = new QuantityContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_quantity);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			match(NUMBER);
			setState(631);
			match(UNIT);
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(632);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RatioContext extends ParserRuleContext {
		public List<RatioPartContext> ratioPart() {
			return getRuleContexts(RatioPartContext.class);
		}
		public RatioPartContext ratioPart(int i) {
			return getRuleContext(RatioPartContext.class,i);
		}
		public TerminalNode COLON() { return getToken(FSHParser.COLON, 0); }
		public RatioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ratio; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterRatio(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitRatio(this);
		}
	}

	public final RatioContext ratio() throws RecognitionException {
		RatioContext _localctx = new RatioContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_ratio);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			ratioPart();
			setState(636);
			match(COLON);
			setState(637);
			ratioPart();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public TerminalNode OR_REFERENCE() { return getToken(FSHParser.OR_REFERENCE, 0); }
		public TerminalNode PIPE_REFERENCE() { return getToken(FSHParser.PIPE_REFERENCE, 0); }
		public TerminalNode STRING() { return getToken(FSHParser.STRING, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitReference(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_reference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			_la = _input.LA(1);
			if ( !(_la==OR_REFERENCE || _la==PIPE_REFERENCE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(640);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CanonicalContext extends ParserRuleContext {
		public TerminalNode CANONICAL() { return getToken(FSHParser.CANONICAL, 0); }
		public CanonicalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_canonical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterCanonical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitCanonical(this);
		}
	}

	public final CanonicalContext canonical() throws RecognitionException {
		CanonicalContext _localctx = new CanonicalContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_canonical);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			match(CANONICAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RatioPartContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(FSHParser.NUMBER, 0); }
		public QuantityContext quantity() {
			return getRuleContext(QuantityContext.class,0);
		}
		public RatioPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ratioPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterRatioPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitRatioPart(this);
		}
	}

	public final RatioPartContext ratioPart() throws RecognitionException {
		RatioPartContext _localctx = new RatioPartContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_ratioPart);
		try {
			setState(647);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(645);
				match(NUMBER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(646);
				quantity();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode KW_TRUE() { return getToken(FSHParser.KW_TRUE, 0); }
		public TerminalNode KW_FALSE() { return getToken(FSHParser.KW_FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitBool(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			_la = _input.LA(1);
			if ( !(_la==KW_TRUE || _la==KW_FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TargetTypeContext extends ParserRuleContext {
		public TerminalNode SEQUENCE() { return getToken(FSHParser.SEQUENCE, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TargetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_targetType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).enterTargetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSHListener ) ((FSHListener)listener).exitTargetType(this);
		}
	}

	public final TargetTypeContext targetType() throws RecognitionException {
		TargetTypeContext _localctx = new TargetTypeContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_targetType);
		try {
			setState(653);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEQUENCE:
				enterOuterAlt(_localctx, 1);
				{
				setState(651);
				match(SEQUENCE);
				}
				break;
			case OR_REFERENCE:
			case PIPE_REFERENCE:
				enterOuterAlt(_localctx, 2);
				{
				setState(652);
				reference();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3O\u0292\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\3\2\7\2\u0096\n\2\f\2\16\2\u0099\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00a7\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\6\5\u00b1\n\5\r\5\16\5\u00b2\3\5\7\5\u00b6\n\5\f\5\16\5\u00b9\13\5"+
		"\3\6\3\6\3\6\7\6\u00be\n\6\f\6\16\6\u00c1\13\6\3\6\7\6\u00c4\n\6\f\6\16"+
		"\6\u00c7\13\6\3\7\3\7\3\7\3\7\3\7\5\7\u00ce\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u00d9\n\b\3\t\3\t\3\t\7\t\u00de\n\t\f\t\16\t\u00e1"+
		"\13\t\3\t\7\t\u00e4\n\t\f\t\16\t\u00e7\13\t\3\n\3\n\3\n\3\n\3\n\5\n\u00ee"+
		"\n\n\3\13\3\13\5\13\u00f2\n\13\3\f\3\f\3\f\6\f\u00f7\n\f\r\f\16\f\u00f8"+
		"\3\r\3\r\3\r\3\r\5\r\u00ff\n\r\3\16\3\16\3\16\7\16\u0104\n\16\f\16\16"+
		"\16\u0107\13\16\3\16\7\16\u010a\n\16\f\16\16\16\u010d\13\16\3\17\3\17"+
		"\3\17\5\17\u0112\n\17\3\20\3\20\3\20\5\20\u0117\n\20\3\21\3\21\3\21\7"+
		"\21\u011c\n\21\f\21\16\21\u011f\13\21\3\21\7\21\u0122\n\21\f\21\16\21"+
		"\u0125\13\21\3\22\3\22\3\22\5\22\u012a\n\22\3\23\3\23\3\23\5\23\u012f"+
		"\n\23\3\24\3\24\3\24\6\24\u0134\n\24\r\24\16\24\u0135\3\25\3\25\3\25\5"+
		"\25\u013b\n\25\3\26\3\26\3\26\3\26\3\27\3\27\7\27\u0143\n\27\f\27\16\27"+
		"\u0146\13\27\3\30\3\30\3\30\7\30\u014b\n\30\f\30\16\30\u014e\13\30\3\30"+
		"\7\30\u0151\n\30\f\30\16\30\u0154\13\30\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u015b\n\31\3\32\3\32\5\32\u015f\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\""+
		"\3\"\3#\3#\3#\3$\3$\3$\7$\u017f\n$\f$\16$\u0182\13$\3$\3$\5$\u0186\n$"+
		"\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\7\'\u0192\n\'\f\'\16\'\u0195\13\'\3"+
		"(\3(\3(\3(\7(\u019b\n(\f(\16(\u019e\13(\3(\3(\5(\u01a2\n(\3(\6(\u01a5"+
		"\n(\r(\16(\u01a6\3)\3)\3)\5)\u01ac\n)\3)\3)\3)\5)\u01b1\n)\3*\3*\3*\5"+
		"*\u01b6\n*\3*\3*\3*\5*\u01bb\n*\3+\3+\3+\3+\3+\3+\7+\u01c3\n+\f+\16+\u01c6"+
		"\13+\3,\3,\3,\3,\3,\3,\7,\u01ce\n,\f,\16,\u01d1\13,\3-\3-\5-\u01d5\n-"+
		"\3-\3-\3-\3-\7-\u01db\n-\f-\16-\u01de\13-\3.\3.\5.\u01e2\n.\3.\3.\3.\3"+
		".\3/\3/\5/\u01ea\n/\3/\3/\3/\5/\u01ef\n/\3/\5/\u01f2\n/\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\5\61\u01fa\n\61\3\61\3\61\5\61\u01fe\n\61\3\62\3\62\5"+
		"\62\u0202\n\62\3\62\3\62\3\62\6\62\u0207\n\62\r\62\16\62\u0208\3\62\3"+
		"\62\3\62\3\62\3\62\5\62\u0210\n\62\3\63\3\63\3\63\3\63\5\63\u0216\n\63"+
		"\3\64\3\64\3\64\3\64\5\64\u021c\n\64\3\64\3\64\3\64\5\64\u0221\n\64\5"+
		"\64\u0223\n\64\3\65\3\65\3\65\3\66\3\66\3\66\7\66\u022b\n\66\f\66\16\66"+
		"\u022e\13\66\3\66\3\66\5\66\u0232\n\66\3\67\3\67\3\67\7\67\u0237\n\67"+
		"\f\67\16\67\u023a\13\67\3\67\3\67\38\38\38\58\u0241\n8\39\39\3:\3:\3:"+
		"\3:\3:\5:\u024a\n:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\5@\u0262\n@\3A\3A\3A\5A\u0267\nA\3A\3A\7A\u026b\nA\fA"+
		"\16A\u026e\13A\3B\3B\5B\u0272\nB\3C\3C\3C\5C\u0277\nC\3D\3D\3D\5D\u027c"+
		"\nD\3E\3E\3E\3E\3F\3F\5F\u0284\nF\3G\3G\3H\3H\5H\u028a\nH\3I\3I\3J\3J"+
		"\5J\u0290\nJ\3J\2\2K\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\2\f\4\2\3\6\b\f\3\29:\3\2NO\3\2+"+
		",\4\2\64\64KK\4\2\60\60KK\3\2\30\35\3\2\37\"\3\2BC\3\2)*\2\u02bb\2\u0097"+
		"\3\2\2\2\4\u00a6\3\2\2\2\6\u00a8\3\2\2\2\b\u00ad\3\2\2\2\n\u00ba\3\2\2"+
		"\2\f\u00cd\3\2\2\2\16\u00d8\3\2\2\2\20\u00da\3\2\2\2\22\u00ed\3\2\2\2"+
		"\24\u00f1\3\2\2\2\26\u00f3\3\2\2\2\30\u00fe\3\2\2\2\32\u0100\3\2\2\2\34"+
		"\u0111\3\2\2\2\36\u0116\3\2\2\2 \u0118\3\2\2\2\"\u0129\3\2\2\2$\u012e"+
		"\3\2\2\2&\u0130\3\2\2\2(\u013a\3\2\2\2*\u013c\3\2\2\2,\u0140\3\2\2\2."+
		"\u0147\3\2\2\2\60\u015a\3\2\2\2\62\u015e\3\2\2\2\64\u0160\3\2\2\2\66\u0163"+
		"\3\2\2\28\u0166\3\2\2\2:\u0169\3\2\2\2<\u016c\3\2\2\2>\u016f\3\2\2\2@"+
		"\u0172\3\2\2\2B\u0175\3\2\2\2D\u0178\3\2\2\2F\u017b\3\2\2\2H\u0187\3\2"+
		"\2\2J\u018a\3\2\2\2L\u018d\3\2\2\2N\u0196\3\2\2\2P\u01a8\3\2\2\2R\u01b2"+
		"\3\2\2\2T\u01bc\3\2\2\2V\u01c7\3\2\2\2X\u01d2\3\2\2\2Z\u01df\3\2\2\2\\"+
		"\u01e7\3\2\2\2^\u01f3\3\2\2\2`\u01f7\3\2\2\2b\u020f\3\2\2\2d\u0211\3\2"+
		"\2\2f\u0217\3\2\2\2h\u0224\3\2\2\2j\u0227\3\2\2\2l\u0238\3\2\2\2n\u023d"+
		"\3\2\2\2p\u0242\3\2\2\2r\u0249\3\2\2\2t\u024b\3\2\2\2v\u024d\3\2\2\2x"+
		"\u024f\3\2\2\2z\u0251\3\2\2\2|\u0253\3\2\2\2~\u0261\3\2\2\2\u0080\u0263"+
		"\3\2\2\2\u0082\u026f\3\2\2\2\u0084\u0273\3\2\2\2\u0086\u0278\3\2\2\2\u0088"+
		"\u027d\3\2\2\2\u008a\u0281\3\2\2\2\u008c\u0285\3\2\2\2\u008e\u0289\3\2"+
		"\2\2\u0090\u028b\3\2\2\2\u0092\u028f\3\2\2\2\u0094\u0096\5\4\3\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7\2\2\3\u009b"+
		"\3\3\2\2\2\u009c\u00a7\5\6\4\2\u009d\u00a7\5\b\5\2\u009e\u00a7\5\n\6\2"+
		"\u009f\u00a7\5\26\f\2\u00a0\u00a7\5\20\t\2\u00a1\u00a7\5\32\16\2\u00a2"+
		"\u00a7\5 \21\2\u00a3\u00a7\5&\24\2\u00a4\u00a7\5*\26\2\u00a5\u00a7\5."+
		"\30\2\u00a6\u009c\3\2\2\2\u00a6\u009d\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6"+
		"\u009f\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a2\3\2"+
		"\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\5\3\2\2\2\u00a8\u00a9\7\3\2\2\u00a9\u00aa\7K\2\2\u00aa\u00ab\7\64\2\2"+
		"\u00ab\u00ac\7K\2\2\u00ac\7\3\2\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00b0\7"+
		"K\2\2\u00af\u00b1\5\f\7\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b7\3\2\2\2\u00b4\u00b6\5\16"+
		"\b\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\t\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7\5\2\2"+
		"\u00bb\u00bf\7K\2\2\u00bc\u00be\5\f\7\2\u00bd\u00bc\3\2\2\2\u00be\u00c1"+
		"\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c5\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c4\5\16\b\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\13\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00ce\5\64\33\2\u00c9\u00ce\5\66\34\2\u00ca\u00ce"+
		"\58\35\2\u00cb\u00ce\5:\36\2\u00cc\u00ce\5F$\2\u00cd\u00c8\3\2\2\2\u00cd"+
		"\u00c9\3\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2"+
		"\2\2\u00ce\r\3\2\2\2\u00cf\u00d9\5L\'\2\u00d0\u00d9\5N(\2\u00d1\u00d9"+
		"\5P)\2\u00d2\u00d9\5R*\2\u00d3\u00d9\5T+\2\u00d4\u00d9\5V,\2\u00d5\u00d9"+
		"\5X-\2\u00d6\u00d9\5Z.\2\u00d7\u00d9\5^\60\2\u00d8\u00cf\3\2\2\2\u00d8"+
		"\u00d0\3\2\2\2\u00d8\u00d1\3\2\2\2\u00d8\u00d2\3\2\2\2\u00d8\u00d3\3\2"+
		"\2\2\u00d8\u00d4\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\17\3\2\2\2\u00da\u00db\7\6\2\2\u00db\u00df\7K\2\2"+
		"\u00dc\u00de\5\22\n\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e5\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e4\5\24\13\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3"+
		"\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\21\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		"\u00ee\5B\"\2\u00e9\u00ee\58\35\2\u00ea\u00ee\5:\36\2\u00eb\u00ee\5D#"+
		"\2\u00ec\u00ee\5F$\2\u00ed\u00e8\3\2\2\2\u00ed\u00e9\3\2\2\2\u00ed\u00ea"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\23\3\2\2\2\u00ef"+
		"\u00f2\5R*\2\u00f0\u00f2\5^\60\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2"+
		"\2\u00f2\25\3\2\2\2\u00f3\u00f4\7\b\2\2\u00f4\u00f6\7K\2\2\u00f5\u00f7"+
		"\5\30\r\2\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2"+
		"\u00f8\u00f9\3\2\2\2\u00f9\27\3\2\2\2\u00fa\u00ff\5:\36\2\u00fb\u00ff"+
		"\5<\37\2\u00fc\u00ff\5> \2\u00fd\u00ff\5@!\2\u00fe\u00fa\3\2\2\2\u00fe"+
		"\u00fb\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\31\3\2\2"+
		"\2\u0100\u0101\7\t\2\2\u0101\u0105\7K\2\2\u0102\u0104\5\34\17\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u010b\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u010a\5\36\20\2\u0109"+
		"\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2"+
		"\2\2\u010c\33\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0112\5\66\34\2\u010f"+
		"\u0112\58\35\2\u0110\u0112\5:\36\2\u0111\u010e\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0110\3\2\2\2\u0112\35\3\2\2\2\u0113\u0117\5`\61\2\u0114\u0117"+
		"\5Z.\2\u0115\u0117\5^\60\2\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0115\3\2\2\2\u0117\37\3\2\2\2\u0118\u0119\7\n\2\2\u0119\u011d\7K\2\2"+
		"\u011a\u011c\5\"\22\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0123\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0122\5$\23\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124!\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u012a"+
		"\5\66\34\2\u0127\u012a\58\35\2\u0128\u012a\5:\36\2\u0129\u0126\3\2\2\2"+
		"\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a#\3\2\2\2\u012b\u012f\5"+
		"\u0084C\2\u012c\u012f\5Z.\2\u012d\u012f\5^\60\2\u012e\u012b\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f%\3\2\2\2\u0130\u0131\7\13\2\2"+
		"\u0131\u0133\7O\2\2\u0132\u0134\5(\25\2\u0133\u0132\3\2\2\2\u0134\u0135"+
		"\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\'\3\2\2\2\u0137"+
		"\u013b\5\16\b\2\u0138\u013b\5\u0084C\2\u0139\u013b\5`\61\2\u013a\u0137"+
		"\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2\2\u013b)\3\2\2\2\u013c"+
		"\u013d\7\13\2\2\u013d\u013e\7N\2\2\u013e\u013f\5,\27\2\u013f+\3\2\2\2"+
		"\u0140\u0144\7\65\2\2\u0141\u0143\n\2\2\2\u0142\u0141\3\2\2\2\u0143\u0146"+
		"\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145-\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0147\u0148\7\f\2\2\u0148\u014c\7K\2\2\u0149\u014b\5\60"+
		"\31\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\u0152\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0151\5\62"+
		"\32\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153/\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u015b\5\66\34"+
		"\2\u0156\u015b\5H%\2\u0157\u015b\5J&\2\u0158\u015b\5:\36\2\u0159\u015b"+
		"\58\35\2\u015a\u0155\3\2\2\2\u015a\u0156\3\2\2\2\u015a\u0157\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u0159\3\2\2\2\u015b\61\3\2\2\2\u015c\u015f\5\\/\2"+
		"\u015d\u015f\5^\60\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015f\63"+
		"\3\2\2\2\u0160\u0161\7\16\2\2\u0161\u0162\7K\2\2\u0162\65\3\2\2\2\u0163"+
		"\u0164\7\17\2\2\u0164\u0165\7K\2\2\u0165\67\3\2\2\2\u0166\u0167\7\20\2"+
		"\2\u0167\u0168\79\2\2\u01689\3\2\2\2\u0169\u016a\7\21\2\2\u016a\u016b"+
		"\t\3\2\2\u016b;\3\2\2\2\u016c\u016d\7\22\2\2\u016d\u016e\79\2\2\u016e"+
		"=\3\2\2\2\u016f\u0170\7\23\2\2\u0170\u0171\79\2\2\u0171?\3\2\2\2\u0172"+
		"\u0173\7\24\2\2\u0173\u0174\7=\2\2\u0174A\3\2\2\2\u0175\u0176\7\7\2\2"+
		"\u0176\u0177\7K\2\2\u0177C\3\2\2\2\u0178\u0179\7\25\2\2\u0179\u017a\7"+
		"=\2\2\u017aE\3\2\2\2\u017b\u0185\7\r\2\2\u017c\u017d\7K\2\2\u017d\u017f"+
		"\7%\2\2\u017e\u017c\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0183\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0186\7K"+
		"\2\2\u0184\u0186\7I\2\2\u0185\u0180\3\2\2\2\u0185\u0184\3\2\2\2\u0186"+
		"G\3\2\2\2\u0187\u0188\7\26\2\2\u0188\u0189\7K\2\2\u0189I\3\2\2\2\u018a"+
		"\u018b\7\27\2\2\u018b\u018c\79\2\2\u018cK\3\2\2\2\u018d\u018e\7\65\2\2"+
		"\u018e\u018f\5t;\2\u018f\u0193\7A\2\2\u0190\u0192\5z>\2\u0191\u0190\3"+
		"\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194"+
		"M\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u01a1\7\65\2\2\u0197\u0198\5t;\2\u0198"+
		"\u0199\7%\2\2\u0199\u019b\3\2\2\2\u019a\u0197\3\2\2\2\u019b\u019e\3\2"+
		"\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019f\u01a2\5t;\2\u01a0\u01a2\5v<\2\u01a1\u019c\3\2\2\2"+
		"\u01a1\u01a0\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a5\5z>\2\u01a4\u01a3"+
		"\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7"+
		"O\3\2\2\2\u01a8\u01a9\7\65\2\2\u01a9\u01ab\5t;\2\u01aa\u01ac\7\61\2\2"+
		"\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01ae"+
		"\7\36\2\2\u01ae\u01b0\7K\2\2\u01af\u01b1\5|?\2\u01b0\u01af\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1Q\3\2\2\2\u01b2\u01b3\7\65\2\2\u01b3\u01b5\5t;\2\u01b4"+
		"\u01b6\7\61\2\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3"+
		"\2\2\2\u01b7\u01b8\7\64\2\2\u01b8\u01ba\5~@\2\u01b9\u01bb\7\62\2\2\u01ba"+
		"\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bbS\3\2\2\2\u01bc\u01bd\7\65\2\2"+
		"\u01bd\u01be\5t;\2\u01be\u01bf\7#\2\2\u01bf\u01c4\5\u0080A\2\u01c0\u01c1"+
		"\7%\2\2\u01c1\u01c3\5\u0080A\2\u01c2\u01c0\3\2\2\2\u01c3\u01c6\3\2\2\2"+
		"\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5U\3\2\2\2\u01c6\u01c4\3"+
		"\2\2\2\u01c7\u01c8\7\65\2\2\u01c8\u01c9\5t;\2\u01c9\u01ca\7&\2\2\u01ca"+
		"\u01cf\5\u0092J\2\u01cb\u01cc\7\'\2\2\u01cc\u01ce\5\u0092J\2\u01cd\u01cb"+
		"\3\2\2\2\u01ce\u01d1\3\2\2\2\u01cf\u01cd\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0"+
		"W\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d2\u01d4\7\65\2\2\u01d3\u01d5\5t;\2\u01d4"+
		"\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\7("+
		"\2\2\u01d7\u01dc\7K\2\2\u01d8\u01d9\7%\2\2\u01d9\u01db\7K\2\2\u01da\u01d8"+
		"\3\2\2\2\u01db\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd"+
		"Y\3\2\2\2\u01de\u01dc\3\2\2\2\u01df\u01e1\7\65\2\2\u01e0\u01e2\5t;\2\u01e1"+
		"\u01e0\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\5x"+
		"=\2\u01e4\u01e5\7\64\2\2\u01e5\u01e6\5~@\2\u01e6[\3\2\2\2\u01e7\u01e9"+
		"\7\65\2\2\u01e8\u01ea\5t;\2\u01e9\u01e8\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea"+
		"\u01eb\3\2\2\2\u01eb\u01ec\78\2\2\u01ec\u01ee\79\2\2\u01ed\u01ef\79\2"+
		"\2\u01ee\u01ed\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01f2"+
		"\7=\2\2\u01f1\u01f0\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2]\3\2\2\2\u01f3\u01f4"+
		"\7\65\2\2\u01f4\u01f5\7\63\2\2\u01f5\u01f6\t\4\2\2\u01f6_\3\2\2\2\u01f7"+
		"\u01f9\7\65\2\2\u01f8\u01fa\t\5\2\2\u01f9\u01f8\3\2\2\2\u01f9\u01fa\3"+
		"\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01fe\5b\62\2\u01fc\u01fe\5d\63\2\u01fd"+
		"\u01fb\3\2\2\2\u01fd\u01fc\3\2\2\2\u01fea\3\2\2\2\u01ff\u0201\5\u0082"+
		"B\2\u0200\u0202\5f\64\2\u0201\u0200\3\2\2\2\u0201\u0202\3\2\2\2\u0202"+
		"\u0210\3\2\2\2\u0203\u0204\5\u0082B\2\u0204\u0205\7%\2\2\u0205\u0207\3"+
		"\2\2\2\u0206\u0203\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0206\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020b\5\u0082B\2\u020b\u020c"+
		"\5f\64\2\u020c\u0210\3\2\2\2\u020d\u020e\7G\2\2\u020e\u0210\5f\64\2\u020f"+
		"\u01ff\3\2\2\2\u020f\u0206\3\2\2\2\u020f\u020d\3\2\2\2\u0210c\3\2\2\2"+
		"\u0211\u0212\7-\2\2\u0212\u0215\5f\64\2\u0213\u0214\7.\2\2\u0214\u0216"+
		"\5l\67\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216e\3\2\2\2\u0217"+
		"\u0222\7\36\2\2\u0218\u021b\5h\65\2\u0219\u021a\7%\2\2\u021a\u021c\5j"+
		"\66\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u0223\3\2\2\2\u021d"+
		"\u0220\5j\66\2\u021e\u021f\7%\2\2\u021f\u0221\5h\65\2\u0220\u021e\3\2"+
		"\2\2\u0220\u0221\3\2\2\2\u0221\u0223\3\2\2\2\u0222\u0218\3\2\2\2\u0222"+
		"\u021d\3\2\2\2\u0223g\3\2\2\2\u0224\u0225\7\60\2\2\u0225\u0226\7K\2\2"+
		"\u0226i\3\2\2\2\u0227\u0231\7/\2\2\u0228\u0229\7K\2\2\u0229\u022b\7%\2"+
		"\2\u022a\u0228\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d"+
		"\3\2\2\2\u022d\u022f\3\2\2\2\u022e\u022c\3\2\2\2\u022f\u0232\7K\2\2\u0230"+
		"\u0232\7I\2\2\u0231\u022c\3\2\2\2\u0231\u0230\3\2\2\2\u0232k\3\2\2\2\u0233"+
		"\u0234\5n8\2\u0234\u0235\7%\2\2\u0235\u0237\3\2\2\2\u0236\u0233\3\2\2"+
		"\2\u0237\u023a\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023b"+
		"\3\2\2\2\u023a\u0238\3\2\2\2\u023b\u023c\5n8\2\u023cm\3\2\2\2\u023d\u023e"+
		"\7K\2\2\u023e\u0240\5p9\2\u023f\u0241\5r:\2\u0240\u023f\3\2\2\2\u0240"+
		"\u0241\3\2\2\2\u0241o\3\2\2\2\u0242\u0243\t\6\2\2\u0243q\3\2\2\2\u0244"+
		"\u024a\5\u0082B\2\u0245\u024a\7)\2\2\u0246\u024a\7*\2\2\u0247\u024a\7"+
		"F\2\2\u0248\u024a\79\2\2\u0249\u0244\3\2\2\2\u0249\u0245\3\2\2\2\u0249"+
		"\u0246\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u0248\3\2\2\2\u024as\3\2\2\2"+
		"\u024b\u024c\t\7\2\2\u024cu\3\2\2\2\u024d\u024e\7I\2\2\u024ew\3\2\2\2"+
		"\u024f\u0250\7E\2\2\u0250y\3\2\2\2\u0251\u0252\t\b\2\2\u0252{\3\2\2\2"+
		"\u0253\u0254\t\t\2\2\u0254}\3\2\2\2\u0255\u0262\7K\2\2\u0256\u0262\79"+
		"\2\2\u0257\u0262\7:\2\2\u0258\u0262\7;\2\2\u0259\u0262\7?\2\2\u025a\u0262"+
		"\7@\2\2\u025b\u0262\5\u008aF\2\u025c\u0262\5\u008cG\2\u025d\u0262\5\u0082"+
		"B\2\u025e\u0262\5\u0086D\2\u025f\u0262\5\u0088E\2\u0260\u0262\5\u0090"+
		"I\2\u0261\u0255\3\2\2\2\u0261\u0256\3\2\2\2\u0261\u0257\3\2\2\2\u0261"+
		"\u0258\3\2\2\2\u0261\u0259\3\2\2\2\u0261\u025a\3\2\2\2\u0261\u025b\3\2"+
		"\2\2\u0261\u025c\3\2\2\2\u0261\u025d\3\2\2\2\u0261\u025e\3\2\2\2\u0261"+
		"\u025f\3\2\2\2\u0261\u0260\3\2\2\2\u0262\177\3\2\2\2\u0263\u0266\7K\2"+
		"\2\u0264\u0265\7$\2\2\u0265\u0267\7K\2\2\u0266\u0264\3\2\2\2\u0266\u0267"+
		"\3\2\2\2\u0267\u0268\3\2\2\2\u0268\u026c\7A\2\2\u0269\u026b\5z>\2\u026a"+
		"\u0269\3\2\2\2\u026b\u026e\3\2\2\2\u026c\u026a\3\2\2\2\u026c\u026d\3\2"+
		"\2\2\u026d\u0081\3\2\2\2\u026e\u026c\3\2\2\2\u026f\u0271\7=\2\2\u0270"+
		"\u0272\79\2\2\u0271\u0270\3\2\2\2\u0271\u0272\3\2\2\2\u0272\u0083\3\2"+
		"\2\2\u0273\u0274\7\65\2\2\u0274\u0276\5\u0082B\2\u0275\u0277\t\3\2\2\u0276"+
		"\u0275\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0085\3\2\2\2\u0278\u0279\7;"+
		"\2\2\u0279\u027b\7<\2\2\u027a\u027c\79\2\2\u027b\u027a\3\2\2\2\u027b\u027c"+
		"\3\2\2\2\u027c\u0087\3\2\2\2\u027d\u027e\5\u008eH\2\u027e\u027f\7\66\2"+
		"\2\u027f\u0280\5\u008eH\2\u0280\u0089\3\2\2\2\u0281\u0283\t\n\2\2\u0282"+
		"\u0284\79\2\2\u0283\u0282\3\2\2\2\u0283\u0284\3\2\2\2\u0284\u008b\3\2"+
		"\2\2\u0285\u0286\7D\2\2\u0286\u008d\3\2\2\2\u0287\u028a\7;\2\2\u0288\u028a"+
		"\5\u0086D\2\u0289\u0287\3\2\2\2\u0289\u0288\3\2\2\2\u028a\u008f\3\2\2"+
		"\2\u028b\u028c\t\13\2\2\u028c\u0091\3\2\2\2\u028d\u0290\7K\2\2\u028e\u0290"+
		"\5\u008aF\2\u028f\u028d\3\2\2\2\u028f\u028e\3\2\2\2\u0290\u0093\3\2\2"+
		"\2H\u0097\u00a6\u00b2\u00b7\u00bf\u00c5\u00cd\u00d8\u00df\u00e5\u00ed"+
		"\u00f1\u00f8\u00fe\u0105\u010b\u0111\u0116\u011d\u0123\u0129\u012e\u0135"+
		"\u013a\u0144\u014c\u0152\u015a\u015e\u0180\u0185\u0193\u019c\u01a1\u01a6"+
		"\u01ab\u01b0\u01b5\u01ba\u01c4\u01cf\u01d4\u01dc\u01e1\u01e9\u01ee\u01f1"+
		"\u01f9\u01fd\u0201\u0208\u020f\u0215\u021b\u0220\u0222\u022c\u0231\u0238"+
		"\u0240\u0249\u0261\u0266\u026c\u0271\u0276\u027b\u0283\u0289\u028f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}